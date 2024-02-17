package peaksoft.service;

import peaksoft.model.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Lesson lesson);
    void updateLesson(Long id, Lesson lesson);
    void deleteLesson(Long id);
    Lesson getLessonById(Long id);
    List<Lesson> getAllLesson();
}
