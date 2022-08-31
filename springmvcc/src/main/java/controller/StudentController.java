package controller;



import dao.StudentDAO;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;

import static java.io.File.separator;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public ModelAndView add(){
        return new ModelAndView("student-form","command",new Student());
    }

//    @RequestMapping(value = "save",method = RequestMethod.POST)
//    public ModelAndView save(@RequestParam(value = "name",required = false) String name,
//                             @RequestParam(value = "age",required = false) int age){
//        Student student = new Student(name,age);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("student-view");
//        mv.addObject("student",student);
//        return mv;
//    }

    @RequestMapping(value = "student/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("command") Student student, BindingResult result){
        ModelAndView mv = new ModelAndView();
        if(student.getId()>0){
            studentDAO.update(student);
        }else {
            studentDAO.insert(student);
        }

        mv.setViewName("student-view");
        mv.addObject("student",student);
        return mv;
    }

    @RequestMapping(value = "list")
    public ModelAndView listStudent(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("student-list");
        mv.addObject("students",studentDAO.listStudent());
        return mv;
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) throws SQLException {
        studentDAO.delete(id);
        return "redirect:/student/list";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView edit(@PathVariable("id") Integer id){
            Student student = studentDAO.findById(id);
            return new ModelAndView("/student/student-form","command",student);
    }

    @RequestMapping(value = "json/{id}",method = RequestMethod.GET)
    public Student viewJson(@RequestBody Integer id){
        return studentDAO.findById(id);
    }

    @RequestMapping(value = "/student/avatar/save",method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()){
            return "student.error";
        }

        byte[] bytes = file.getBytes();
        System.out.println("found--- > " + bytes.length);
        return "redirect:/student/list";
    }

    private Path  getImageFile(HttpServletRequest request, Integer id){
        ServletContext servletContext = request.getSession().getServletContext();
        String diskPath = servletContext.getRealPath("/");
        File folder = new File(diskPath + separator + "avatar" + separator);
        folder.mkdirs();
        return new File(folder,String.valueOf(id)+".jpg").toPath();
    }
}
