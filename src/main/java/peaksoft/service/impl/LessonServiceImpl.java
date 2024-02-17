package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Lesson;
import peaksoft.repo.LessonRepository;
import peaksoft.service.LessonService;

import java.util.List;
@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Override
    public void saveLesson(Lesson lesson) {
        lessonRepository.saveLesson(lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        lessonRepository.updateLesson(id,lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteLesson(id);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepository.getAllLesson();
    }
}
