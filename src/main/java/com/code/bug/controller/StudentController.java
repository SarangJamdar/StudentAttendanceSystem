package com.code.bug.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.code.bug.model.Student;
import com.code.bug.service.StudentService;

@RestController
public class StudentController {
	@Autowired
    private StudentService studentService;
 
	ModelAndView modelAndView = new ModelAndView();
	
    @GetMapping("/")
    public ModelAndView viewHomePage(Model model) {
    	System.out.println("Duck");
        return findPaginated(1, "studentName", "asc", model);
    }
 
    @GetMapping("/new")
    public String loadNewPage() {
    	System.out.println("Duck");
        return "Success"; // Return the name of the HTML template (without the .html extension)
    }
    
    @GetMapping("/add")
    public ModelAndView showNewStudentForm(Model model) {
    	
        Student student = new Student();
        model.addAttribute("studentTest", student);
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("inside add");
        model.addAttribute("rollno", "");
        model.addAttribute("studentName", "");
        model.addAttribute("lecture", "");
        model.addAttribute("attend", "");

    	modelAndView.setViewName("new_student.html");
        return modelAndView;
    }
 
    @PostMapping("/save")
    public ModelAndView saveStudent(@ModelAttribute("studentTest") Student student) {
        // save Student to database
    	System.out.println("*************inside SAVE**************************" + student.getStudentName());
        studentService.saveStudent(student);
        modelAndView.setViewName("main.html");
		return new ModelAndView( "redirect:/");
    }
 
    @GetMapping("/update/{id}")
    public ModelAndView showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
 
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        modelAndView.setViewName("update_student.html");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable (value = "id") long id) {
 
        this.studentService.deleteStudentById(id);
        return new ModelAndView( "redirect:/");
    }
 
 
    @GetMapping("/page/{pageNo}")
    public ModelAndView findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
 
        Page<Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        java.util.List<Student> listStudents = page.getContent();
        
        System.out.println(listStudents.isEmpty());
 
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
 
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
 
        model.addAttribute("listStudents", listStudents);
        
        modelAndView.setViewName("main.html");
        return modelAndView;
       // return "redirect:/index";
    }
    
}
