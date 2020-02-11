package my_spring_boot.mydemo.controller;

import java.io.IOException;
import java.io.Writer;
import java.lang.management.MemoryType;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller
// public class SampkeController {
//   // URL を指定する
//   @RequestMapping("/sample")
//   public String sample() {
//     // テンプレート名を指定する
//     return "sample";
//   }
// }

// @Controller
//     public class SampkeController {
//         //URLを指定する
//         @RequestMapping("/") 
//             public String sample(Model model){
//                 //テンプレート名を指定する.
//                 model.addAllAttributes("msg","Hello");
//                 return "sample";
            
//         }
//     }


    // import org.springframework.stereotype.Controller;
    // import org.springframework.ui.Model;
    // import org.springframework.web.bind.annotation.RequestMapping;
  
    @Controller
    public class Sampke {
  
        @RequestMapping("/list")
        public String index(Model model) {
            model.addAttribute("msg", "kusaman Hello");
            return "index";
        }

        @RequestMapping("/test")
        @ResponseBody
        public String test() throws IOException {
            return "{index:0}";
        }

        @RequestMapping("/test/{userId}/{opeId}")
        @ResponseBody
        public String test(@PathVariable("userId") String id, @PathVariable("opeId") String oid) {
            return "{user_id:"+id+",opeid:"+oid+"}";
        }

        
    }
