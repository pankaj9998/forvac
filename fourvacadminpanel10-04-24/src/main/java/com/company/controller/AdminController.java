//package com.company.controller;
//
////AdminController.java
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.company.entity.AdminLoginRequest;
//import com.company.services.AdminService;
//
//@RestController
//public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//    
//    @PostMapping("/admin/login")
//    public String login(@RequestBody AdminLoginRequest request) {
//        String username = request.getUsername();
//        String password = request.getPassword();
//        
//        if(adminService.isValidAdmin(username, password)) {
//            return "Login successful";
//        } else {
//            return "Invalid credentials";
//        }
//    }
//}
//
//

package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.entity.AdminLoginRequest;
import com.company.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
//    @RequestMapping("/login") // Handling both GET and POST requests for /admin/login
//    public String showLoginForm() {
//        return "login"; // Assuming "login.html" is the name of your login form Thymeleaf template
//    }
    
    @RequestMapping("/login") // Handling both GET and POST requests for /admin/login
    public String showLoginForm(Model model) {
        model.addAttribute("C:\\Users\\panka\\Picture", "file:///C:/Users/panka/Desktop/New%20folder%20(2)/p/adminpanel%20(1)%20(1)/adminpanel/src/main/resources/static/img/logo.png"); // Update with the actual path or URL of your logo image
        return "login"; // Assuming "login.html" is the name of your login form Thymeleaf template
    }

    
    
    @GetMapping("/admin/login")
    public String logout(RedirectAttributes redirectAttributes) {
        // Perform any logout actions if necessary
        
        // Redirect to the login page after logout
        return "redirect:/admin/login";
    }
    
    @PostMapping("/login")
    public String login(AdminLoginRequest request, RedirectAttributes redirectAttributes) {
        String username = request.getUsername();
        String password = request.getPassword();
        
        if(adminService.isValidAdmin(username, password)) {
            // If login is successful, redirect to the dashboard page
            return "redirect:/dashboard"; // Assuming "/admin/dashboard" is the endpoint for the dashboard
        } else {
            // If login fails, add an error message and return to the login page
            redirectAttributes.addFlashAttribute("error", "Invalid credentials");
            return "redirect:/admin/login";
            
            
        
        }
    }
}
