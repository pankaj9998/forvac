//package com.company.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.company.entity.Category;
//import com.company.entity.Image;
//import com.company.entity.PDFFile;
//import com.company.repository.CategoryRepository;
//import com.company.repository.ImageRepository;
//import com.company.repository.PDFFileRepository;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//
//@Controller
//public class MainController 
//{	
//	@Autowired
//	private CategoryRepository categoryRepository;
//	
//	@Autowired 
//	private PDFFileRepository pdfFileRepository;
//	
//	 @Autowired
//	 private JavaMailSender javaMailSender;
//	 
//	
//	@Autowired
//    private ImageRepository imageRepository;
//
//	@GetMapping("/")
//	public String index()
//	{
//		return "index";
//	}
//	
//	@GetMapping("/dashboard")
//	public String dashboard()
//	{
//		return "index";
//	}
//	
//    @GetMapping("/home")
//    public String showCategories(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//    	List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
//        
//        return "homeindex"; // Name of your Thymeleaf template
//    }
//    
//	
//	
//    @GetMapping("/products")
//    public String view(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//        List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
//        model.addAttribute("commonCategoryName", categoryName);
//
//        return "ourProductsImage";
//    }
//
//	@GetMapping("/aboutus")
//	public String aboutus(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//    	List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);  
//		return "aboutus";
//	}
//	
//	
//	
//	@GetMapping("/ourservices")
//	public String ourservices(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//    	List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
//        
//   
//		return "ourservices";
//	}
//	
//	@GetMapping("/agencies")
//	public String agencies(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//    	List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
//        
//       
//		return "fourvac-agencies";
//	}
//	
//	
//	@GetMapping("/getquotation")
//	public String getquotation(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//    	List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
//		return "getquotation";
//	}
//	
//	
//	
//	@GetMapping("/contactus")
//	public String contactus(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//    	List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);	return "contactus";
//	}
//	
////	
////	@GetMapping("/products")
////	public String products(@RequestParam(name = "category", required = false) String categoryName, Model model)
////	{
////		   List<Image> images;
////	        List<Category> categories = categoryRepository.findAll();
////        
////	        if (categoryName != null && !categoryName.isEmpty()) {
////	            images = imageRepository.findByCategoryName(categoryName);
////	            model.addAttribute("images", images);
////	        }
////	        model.addAttribute("categories", categories);
////        
////		return "ourProducts";
////	}
////	
////	
////	 @GetMapping("/products")
////	    public String products() {
////
////	        return "ourProducts"; // Assuming "ourProducts" is the name of your Thymeleaf template
////	    }
//
//	
//	
//	
//	
//	
//	@GetMapping("/pdf")
//    public String showPdfForm(Model model) {
//        // Fetch the list of categories from the database
//        List<Category> categories = categoryRepository.findAll();
//        List<PDFFile> pdfFile = pdfFileRepository.findAll();
//        
//        model.addAttribute("categories", categories);
//        model.addAttribute("pdfFile", pdfFile);
//        return "pdf"; // This is the name of the Thymeleaf template (pdf.html)
//    }
// 
// @PostMapping("/uploadPdf")
//	public String uploadPdf(@RequestParam("pro_category") String pro_category, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
//	{
//	    if (file.isEmpty()) 
//	    {
//	        redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
//	        return "redirect:/pdf";
//	    }
//	    
//	    try {
//	        // Get the original filename
//	        String originalFilename = file.getOriginalFilename();
//	        
//	        // Create a PDFFile object
//	        PDFFile pdfFile = new PDFFile();
//	        pdfFile.setPro_category(pro_category);
//	        pdfFile.setFilename(originalFilename); // Set the original filename
//	        
//	        // Set the file content
//	        pdfFile.setPdf(file.getBytes());
//	        
//	        // Save the PDFFile object
//	        pdfFileRepository.save(pdfFile);
//	        redirectAttributes.addFlashAttribute("message" , "File uploaded successfully");
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        redirectAttributes.addFlashAttribute("error","Failed to upload file.");
//	    }
//	    return "redirect:/pdf";
//	}
//
// @PostMapping("/deletePdf")
//	public String deletePdf(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
//	    try {
//	        pdfFileRepository.deleteById(id);
//	        redirectAttributes.addFlashAttribute("message", "PDF file deleted successfully");
//	    } catch (Exception e) {
//	        redirectAttributes.addFlashAttribute("error", "Failed to delete PDF file");
//	    }
//	    return "redirect:/pdf";
//	}
// 
//
//	
// 
//
//	@GetMapping("/imageUpload")
//	public String imageUpload(Model model)
//	{
//		List<Category> categories = categoryRepository.findAll();
//     model.addAttribute("categories", categories);
//     
//		return "ImageUpload";
//	}
//	
//
//	@PostMapping("/uploadSingleImage")
//	public String uploadSingleImage(@RequestParam("categoryName") String categoryName,
//	                                @RequestParam("singleImage") MultipartFile file,
//	                                @RequestParam("imageTitle") String imageTitle,
//	                                RedirectAttributes redirectAttributes,
//	                                Model model) {
//	    try {
//	        if (file.isEmpty()) {
//	            redirectAttributes.addFlashAttribute("error", "Please select a file to upload.");
//	            return "redirect:/imageUpload";
//	        }
//
//	        // Get the image file name
//	        String imageName = file.getOriginalFilename();
//	        
//	        if (file.getSize() > 5 *2024 * 2024) { // 5 MB in bytes
//	            redirectAttributes.addFlashAttribute("error", "File size exceeds the limit (5 MB).");
//	            return "redirect:/imageUpload";
//	        }
//
//
//	        // Check if the title already exists
//	        if (imageRepository.existsByCategoryNameAndImageName(categoryName, imageName)) {
//	            redirectAttributes.addFlashAttribute("error", "Image with name '" + imageName + "' already exists for category '" + categoryName + "'.");
//	            return "redirect:/imageUpload";
//	        }
//
//	        Image image = new Image();
//	        image.setCategoryName(categoryName);
//	        image.setImageTitle(imageTitle); // Set the image title as the image name
//	        image.setImageData(file.getBytes());
//	        image.setImageName(imageName);
//	        imageRepository.save(image);
//
//	        // Save the image to the static/img directory
//	        byte[] bytes = file.getBytes();
//	        Path path = Paths.get("src/main/resources/static/img/" + imageName);
//	        Files.write(path, bytes);
//
//	        redirectAttributes.addFlashAttribute("message", "Image uploaded successfully.");
//	    } catch (Exception e) {
//	        redirectAttributes.addFlashAttribute("error", "Failed to upload image: " + e.getMessage());
//	    }
//	    return "redirect:/imageUpload";
//	}
//
//
//
//	 @PostMapping("/addCategory")
//	    public String addCategoryWithMultipleImages(@RequestParam("categoryName") String categoryName,
//	                                                @RequestParam("imageTitle1") String imageTitle1,
//	                                                @RequestParam("image1") MultipartFile file1,
//	                                                @RequestParam("imageTitle2") String imageTitle2,
//	                                                @RequestParam("image2") MultipartFile file2,
//	                                                @RequestParam("imageTitle3") String imageTitle3,
//	                                                @RequestParam("image3") MultipartFile file3,
//	                                                @RequestParam("imageTitle4") String imageTitle4,
//	                                                @RequestParam("image4") MultipartFile file4,
//	                                                RedirectAttributes redirectAttributes) {
//	        try {
//	            List<String> titles = Arrays.asList(imageTitle1, imageTitle2, imageTitle3, imageTitle4);
//	            List<MultipartFile> files = Arrays.asList(file1, file2, file3, file4);
//
//	            
//	            for (int i = 0; i < files.size(); i++) {
//	                MultipartFile file = files.get(i);
//	                String imageTitle = titles.get(i).trim(); 
//	                String imageName = file.getOriginalFilename();
//
//	                if (imageTitle.isEmpty()) {
//	                    continue; // 
//	                }
//
//	                if (file.getSize() > 5 * 2024 * 2024) { // 5 MB in bytes
//	                    redirectAttributes.addFlashAttribute("error", "File size exceeds the limit (5 MB).");
//	                    return "redirect:/imageUpload";
//	                }
//	                // Check if the title already exists
//	                if (imageRepository.existsByCategoryNameAndImageTitle(categoryName, imageTitle)) {
//	                    redirectAttributes.addFlashAttribute("error1", "Image with title '" + imageTitle + "' already exists for category '" + categoryName + "'.");
//	                    return "redirect:/imageUpload";
//	                }
//	                
//	                Image image = new Image();
//	                image.setCategoryName(categoryName);
//	                image.setImageTitle(imageTitle);
//	                image.setImageData(file.getBytes());
//	                image.setImageName(imageName);
//			        imageRepository.save(image);
//	                
//	                byte[] bytes = file.getBytes();
//	                Path path = Paths.get("src/main/resources/static/img/" + file.getOriginalFilename()); // Hardcoded path
//	                Files.write(path, bytes);
//	               
//	                
//	            }
//	            redirectAttributes.addFlashAttribute("message1", "Images uploaded successfully.");
//	        } catch (Exception e) {
//	            redirectAttributes.addFlashAttribute("error", "Failed to upload images: " + e.getMessage());
//	        }
//	        return "redirect:/imageUpload"; 
//	    }
//
//
//
//    
//    
//    @GetMapping("/editcontent")
//    public String editContentPage() {
//        return "edit-content-display";
//    }
//    
////    @GetMapping("/viewImages")
////    public String index(@RequestParam(name = "category", required = false) String categoryName, Model model) {
////        List<Image> images;
////        List<Category> categories = categoryRepository.findAll();
////        
////        if (categoryName != null && !categoryName.isEmpty()) {
////            images = imageRepository.findByCategoryName(categoryName);
////            model.addAttribute("images", images);
////        }
////        model.addAttribute("categories", categories);
//////        model.addAttribute("images", images);
////        return "ViewImages";
////    }
//
//    @GetMapping("/viewImages")
//    public String index(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//        List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
//        return "ViewImages";
//    }
//    
//    @GetMapping("/getImage")
//    public void getImage(@RequestParam("imageName") String imageName, HttpServletResponse response) throws IOException {
//        // Load the image from the file system
//        Path imagePath = Paths.get("src/main/resources/static/img/" + imageName);
//        byte[] imageData = Files.readAllBytes(imagePath);
//
//        // Set the response content type
//        response.setContentType("image/jpeg");
//
//        // Write the image data to the response output stream
//        response.getOutputStream().write(imageData);
//    }
//
//
//    @PostMapping("/deleteImages")
//    public String deleteImages(@RequestParam("imagesToDelete") List<Long> imageIds, RedirectAttributes redirectAttributes) {
//    	
//    	if (imageIds == null || imageIds.isEmpty()) {
//            redirectAttributes.addFlashAttribute("error", "Please select at least one image to delete.");
//            return "redirect:/viewImages";
//        }
//    	
//        try {
//            for (Long id : imageIds) {
//                Image image = imageRepository.findById(id).orElse(null);
//                if (image != null) {
//                    // Delete image from the folder
//                    Path imagePath = Paths.get("src/main/resources/static/img/" + image.getImageTitle());
//                    Files.deleteIfExists(imagePath);
//                    // Delete image from the database
//                    imageRepository.deleteById(id);
//                }
//            }
//            redirectAttributes.addFlashAttribute("success", "Selected images deleted successfully.");
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("error", "Failed to delete selected images.");
//        }
//        return "redirect:/viewImages";
//    }
//    
//    
//    
//    @GetMapping("/contact")
//    public String showContactForm() {
//        return "contact"; // This corresponds to contact.html template
//    }
//    
//    private void sendEmail(String name, String email, String subject, String message) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo("pankaj.swapra99@gmail.com"); // Replace with recipient's email address
//        mailMessage.setSubject("New message from " + name + " (" + email + "): " + subject);
//        mailMessage.setText(message);
//
//        javaMailSender.send(mailMessage);
//    }
//    
//    
//    
//    
// 
//    
//   @PostMapping("/submitContactForm")
//    @ResponseBody
//    public String submitContactForm(@RequestParam("name") String name,
//                                    @RequestParam("email") String email,
//                                    @RequestParam("subject") String subject,
//                                    @RequestParam("message") String message) {
//        // Process form submission (e.g., send email)
//
//        return "Thank you! Your message has been sent.";
//    }
//    
//  
//    
//}




package com.company.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.entity.Category;
import com.company.entity.Image;
import com.company.entity.PDFFile;
import com.company.repository.CategoryRepository;
import com.company.repository.ImageRepository;
import com.company.repository.PDFFileRepository;

import jakarta.servlet.http.HttpServletResponse;


@Controller
public class MainController 
{	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private PDFFileRepository pdfFileRepository;
	 
	
	@Autowired
    private ImageRepository imageRepository;
	
	 @Autowired
	  private JavaMailSender javaMailSender ;

	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard()
	{
		return "index";
	}
	
    @GetMapping("/home")
    public String showCategories(@RequestParam(name = "category", required = false) String categoryName, Model model) {
    	List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);
        
        return "homeindex"; // Name of your Thymeleaf template
    }
    
	
	
    @GetMapping("/products")
    public String view(@RequestParam(name = "category", required = false) String categoryName, Model model) {
        List<Image> images;
        List<Category> categories = categoryRepository.findAll();

        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);
        model.addAttribute("commonCategoryName", categoryName);

        return "ourProductsImage";
    }

	@GetMapping("/aboutus")
	public String aboutus(@RequestParam(name = "category", required = false) String categoryName, Model model) {
    	List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);  
		return "aboutus";
	}
	
	
	
	@GetMapping("/ourservices")
	public String ourservices(@RequestParam(name = "category", required = false) String categoryName, Model model) {
    	List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);
        
   
		return "ourservices";
	}
	
	@GetMapping("/agencies")
	public String agencies(@RequestParam(name = "category", required = false) String categoryName, Model model) {
    	List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);
        
       
		return "fourvac-agencies";
	}
	
	
	@GetMapping("/getquotation")
	public String getquotation(@RequestParam(name = "category", required = false) String categoryName, Model model) {
    	List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);
		return "getquotation";
	}
	
	
	
	@GetMapping("/contactus")
	public String contactus(@RequestParam(name = "category", required = false) String categoryName, Model model) {
    	List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);	return "contactus";
	}
	
//	
//	@GetMapping("/products")
//	public String products(@RequestParam(name = "category", required = false) String categoryName, Model model)
//	{
//		   List<Image> images;
//	        List<Category> categories = categoryRepository.findAll();
//        
//	        if (categoryName != null && !categoryName.isEmpty()) {
//	            images = imageRepository.findByCategoryName(categoryName);
//	            model.addAttribute("images", images);
//	        }
//	        model.addAttribute("categories", categories);
//        
//		return "ourProducts";
//	}
//	
//	
//	 @GetMapping("/products")
//	    public String products() {
//
//	        return "ourProducts"; // Assuming "ourProducts" is the name of your Thymeleaf template
//	    }

	
	
	
	
	
	@GetMapping("/pdf")
    public String showPdfForm(Model model) {
        // Fetch the list of categories from the database
        List<Category> categories = categoryRepository.findAll();
        List<PDFFile> pdfFile = pdfFileRepository.findAll();
        
        model.addAttribute("categories", categories);
        model.addAttribute("pdfFile", pdfFile);
        return "pdf"; // This is the name of the Thymeleaf template (pdf.html)
    }
 
 @PostMapping("/uploadPdf")
	public String uploadPdf(@RequestParam("pro_category") String pro_category, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes)
	{
	    if (file.isEmpty()) 
	    {
	        redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
	        return "redirect:/pdf";
	    }
	    
	    try {
	        // Get the original filename
	        String originalFilename = file.getOriginalFilename();
	        
	        // Create a PDFFile object
	        PDFFile pdfFile = new PDFFile();
	        pdfFile.setPro_category(pro_category);
	        pdfFile.setFilename(originalFilename); // Set the original filename
	        
	        // Set the file content
	        pdfFile.setPdf(file.getBytes());
	        
	        // Save the PDFFile object
	        pdfFileRepository.save(pdfFile);
	        redirectAttributes.addFlashAttribute("message" , "File uploaded successfully");
	    } catch (IOException e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("error","Failed to upload file.");
	    }
	    return "redirect:/pdf";
	}

 @PostMapping("/deletePdf")
	public String deletePdf(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
	    try {
	        pdfFileRepository.deleteById(id);
	        redirectAttributes.addFlashAttribute("message", "PDF file deleted successfully");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Failed to delete PDF file");
	    }
	    return "redirect:/pdf";
	}
 

	
 

	@GetMapping("/imageUpload")
	public String imageUpload(Model model)
	{
		List<Category> categories = categoryRepository.findAll();
     model.addAttribute("categories", categories);
     
		return "ImageUpload";
	}
	

	@PostMapping("/uploadSingleImage")
	public String uploadSingleImage(@RequestParam("categoryName") String categoryName,
	                                @RequestParam("singleImage") MultipartFile file,
	                                @RequestParam("imageTitle") String imageTitle,
	                                RedirectAttributes redirectAttributes,
	                                Model model) {
	    try {
	        if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("error", "Please select a file to upload.");
	            return "redirect:/imageUpload";
	        }

	        // Get the image file name
	        String imageName = file.getOriginalFilename();
	        
	        if (file.getSize() > 5 *2024 * 2024) { // 5 MB in bytes
	            redirectAttributes.addFlashAttribute("error", "File size exceeds the limit (5 MB).");
	            return "redirect:/imageUpload";
	        }


	        // Check if the title already exists
	        if (imageRepository.existsByCategoryNameAndImageName(categoryName, imageName)) {
	            redirectAttributes.addFlashAttribute("error", "Image with name '" + imageName + "' already exists for category '" + categoryName + "'.");
	            return "redirect:/imageUpload";
	        }

	        Image image = new Image();
	        image.setCategoryName(categoryName);
	        image.setImageTitle(imageTitle); // Set the image title as the image name
	        image.setImageData(file.getBytes());
	        image.setImageName(imageName);
	        imageRepository.save(image);

	        // Save the image to the static/img directory
	        byte[] bytes = file.getBytes();
	        Path path = Paths.get("src/main/resources/static/img/" + imageName);
	        Files.write(path, bytes);

	        redirectAttributes.addFlashAttribute("message", "Image uploaded successfully.");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("error", "Failed to upload image: " + e.getMessage());
	    }
	    return "redirect:/imageUpload";
	}



	 @PostMapping("/addCategory")
	    public String addCategoryWithMultipleImages(@RequestParam("categoryName") String categoryName,
	                                                @RequestParam("imageTitle1") String imageTitle1,
	                                                @RequestParam("image1") MultipartFile file1,
	                                                @RequestParam("imageTitle2") String imageTitle2,
	                                                @RequestParam("image2") MultipartFile file2,
	                                                @RequestParam("imageTitle3") String imageTitle3,
	                                                @RequestParam("image3") MultipartFile file3,
	                                                @RequestParam("imageTitle4") String imageTitle4,
	                                                @RequestParam("image4") MultipartFile file4,
	                                                RedirectAttributes redirectAttributes) {
	        try {
	            List<String> titles = Arrays.asList(imageTitle1, imageTitle2, imageTitle3, imageTitle4);
	            List<MultipartFile> files = Arrays.asList(file1, file2, file3, file4);

	            
	            for (int i = 0; i < files.size(); i++) {
	                MultipartFile file = files.get(i);
	                String imageTitle = titles.get(i).trim(); 
	                String imageName = file.getOriginalFilename();

	                if (imageTitle.isEmpty()) {
	                    continue; // 
	                }

	                if (file.getSize() > 5 * 2024 * 2024) { // 5 MB in bytes
	                    redirectAttributes.addFlashAttribute("error", "File size exceeds the limit (5 MB).");
	                    return "redirect:/imageUpload";
	                }
	                // Check if the title already exists
	                if (imageRepository.existsByCategoryNameAndImageTitle(categoryName, imageTitle)) {
	                    redirectAttributes.addFlashAttribute("error1", "Image with title '" + imageTitle + "' already exists for category '" + categoryName + "'.");
	                    return "redirect:/imageUpload";
	                }
	                
	                Image image = new Image();
	                image.setCategoryName(categoryName);
	                image.setImageTitle(imageTitle);
	                image.setImageData(file.getBytes());
	                image.setImageName(imageName);
			        imageRepository.save(image);
	                
	                byte[] bytes = file.getBytes();
	                Path path = Paths.get("src/main/resources/static/img/" + file.getOriginalFilename()); // Hardcoded path
	                Files.write(path, bytes);
	               
	                
	            }
	            redirectAttributes.addFlashAttribute("message1", "Images uploaded successfully.");
	        } catch (Exception e) {
	            redirectAttributes.addFlashAttribute("error", "Failed to upload images: " + e.getMessage());
	        }
	        return "redirect:/imageUpload"; 
	    }



    
    
    @GetMapping("/editcontent")
    public String editContentPage() {
        return "edit-content-display";
    }
    
//    @GetMapping("/viewImages")
//    public String index(@RequestParam(name = "category", required = false) String categoryName, Model model) {
//        List<Image> images;
//        List<Category> categories = categoryRepository.findAll();
//        
//        if (categoryName != null && !categoryName.isEmpty()) {
//            images = imageRepository.findByCategoryName(categoryName);
//            model.addAttribute("images", images);
//        }
//        model.addAttribute("categories", categories);
////        model.addAttribute("images", images);
//        return "ViewImages";
//    }

    @GetMapping("/viewImages")
    public String index(@RequestParam(name = "category", required = false) String categoryName, Model model) {
        List<Image> images;
        List<Category> categories = categoryRepository.findAll();
        
        if (categoryName != null && !categoryName.isEmpty()) {
            images = imageRepository.findByCategoryName(categoryName);
            model.addAttribute("images", images);
        }
        model.addAttribute("categories", categories);
        return "ViewImages";
    }
    
    @GetMapping("/getImage")
    public void getImage(@RequestParam("imageName") String imageName, HttpServletResponse response) throws IOException {
        // Load the image from the file system
        Path imagePath = Paths.get("src/main/resources/static/img/" + imageName);
        byte[] imageData = Files.readAllBytes(imagePath);

        // Set the response content type
        response.setContentType("image/jpeg");

        // Write the image data to the response output stream
        response.getOutputStream().write(imageData);
    }


    @PostMapping("/deleteImages")
    public String deleteImages(@RequestParam("imagesToDelete") List<Long> imageIds, RedirectAttributes redirectAttributes) {
    	
    	if (imageIds == null || imageIds.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select at least one image to delete.");
            return "redirect:/viewImages";
        }
    	
        try {
            for (Long id : imageIds) {
                Image image = imageRepository.findById(id).orElse(null);
                if (image != null) {
                    // Delete image from the folder
                    Path imagePath = Paths.get("src/main/resources/static/img/" + image.getImageTitle());
                    Files.deleteIfExists(imagePath);
                    // Delete image from the database
                    imageRepository.deleteById(id);
                }
            }
            redirectAttributes.addFlashAttribute("success", "Selected images deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete selected images.");
        }
        return "redirect:/viewImages";
    }
    
    
    @GetMapping("/contact")
    public String showContactForm() {
        return "contact"; // This corresponds to contact.html template
    }
    
    private void sendEmail(String name, String email, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("pankaj.swapra99@gmail.com"); // Replace with recipient's email address
        mailMessage.setSubject("New message from " + name + " (" + email + "): " + subject);
        mailMessage.setText(message);

        javaMailSender.send(mailMessage);
    }
    
    
    
    
    
    
    
    
    
    
    @PostMapping("/submitContactForm")
    @ResponseBody
    public String submitContactForm(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("subject") String subject,
                                    @RequestParam("message") String message) {
        // Process form submission (e.g., send email)

        return "Thank you! Your message has been sent.";
    }
    
  
    
    
    
    
}