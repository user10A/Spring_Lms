package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Lesson;
import peaksoft.repo.LessonRepository;

import java.util.List;
@Repository
@Transactional
public class LessonRepoImpl implements LessonRepository {
    @PersistenceContext
private EntityManager entityManager;
    @Override
    public void saveLesson(Lesson lesson) {
        entityManager.persist(lesson);
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        Lesson lesson1 = entityManager.find(Lesson.class,id);
        lesson1.setName(lesson.getName());
        lesson1.setDescription(lesson.getDescription());
        lesson1.setImage(lesson.getImage());
    }

    @Override
    public void deleteLesson(Long id) {
        entityManager.remove(entityManager.find(Lesson.class,id));
    }

    @Override
    public Lesson getLessonById(Long id) {
        return entityManager.find(Lesson.class,id);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return entityManager.createQuery("select l from Lesson l ",Lesson.class).getResultList();
    }
}
