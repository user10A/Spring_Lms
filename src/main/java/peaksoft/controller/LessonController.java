package peaksoft.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Lesson;
import peaksoft.service.LessonService;

@Controller
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    @GetMapping
    public String getAllLessons(Model model){
        model.addAttribute("getAllLessons",lessonService.getAllLesson());
        return "lessons";
    }

    @GetMapping("/create")
    public String createLesson(Model model){
        model.addAttribute("newLesson",new Lesson());
        return "createLesson";
    }
    @PostMapping("/save")
    public String saveLesson(@ModelAttribute(name = "newLesson") Lesson lesson){
        lessonService.saveLesson(lesson);
        return "redirect:/lesson";
    }
    @DeleteMapping("/delete/{lessonId}")
    public String deleteLesson(@PathVariable("lessonId")Long id){
        lessonService.deleteLesson(id);
        return "redirect:/lesson";
    }
    @GetMapping("{lessonId}/get")
    public String getLesson(@PathVariable("lessonId")Long id,Model model){
        model.addAttribute("getMyLesson",lessonService.getLessonById(id));
        return "getPageLesson";
    }
    @GetMapping("/update/{lessonId}")
    public String updateLesson(@PathVariable("lessonId") Long lessonId,Model model) {
        model.addAttribute("updateLesson",lessonService.getLessonById(lessonId));
        return "updatePageLesson";
    }
    @PostMapping("/replace/{lessonId}")
    public String update(@ModelAttribute Lesson lesson,@PathVariable long lessonId){
        lessonService.updateLesson(lessonId,lesson);
        return "redirect:/lesson";
    }
    @GetMapping("/search")
    public String searchById(@RequestParam(name = "id") Long id, Model model) {
        Lesson lesson = lessonService.getLessonById(id);
        if (lesson == null) {
            return "redirect:/lesson";
        }
        model.addAttribute("lessonSearch", lesson);
        return "/getPageLesson";
    }
}
