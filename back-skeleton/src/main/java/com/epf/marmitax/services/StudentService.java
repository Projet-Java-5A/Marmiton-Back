package com.epf.marmitax.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epf.marmitax.DAO.StudentDao;
import com.epf.marmitax.DTO.StudentDto;
import com.epf.marmitax.DTO.StudentMapper;
import com.epf.marmitax.models.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    // Déclaration du DAO pour les étudiants. C'est une dépendance injectée par Spring.
    private final StudentDao studentDao;

    /**
     * Constructeur de la classe StudentService.
     * Spring injecte automatiquement une instance de StudentDao.
     * @param studentDao Le DAO pour les opérations sur les étudiants.
     */
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * Récupère tous les étudiants de la base de données.
     * @return Une liste de tous les étudiants.
     */
    public List<Student> findAll() {
        // Récupère un Iterable de tous les étudiants depuis le DAO.
        Iterable<Student> it = studentDao.findAll();
        // Crée une nouvelle liste pour stocker les étudiants.
        List <Student> users = new ArrayList<>();
        // Convertit l'Iterable en List en ajoutant chaque étudiant à la liste.
        it.forEach(users::add);
        return users ;
    }

    /**
     * Récupère un étudiant par son identifiant.
     * @param id L'identifiant de l'étudiant à récupérer.
     * @return L'étudiant correspondant à l'identifiant.
     * @throws NoSuchElementException si aucun étudiant n'est trouvé avec cet identifiant.
     */
    public Student getById(Long id) {
        // Utilise findById qui retourne un Optional, puis orElseThrow pour lancer une exception si non trouvé.
        return studentDao.findById(id).orElseThrow();
    }

    /**
     * Supprime un étudiant par son identifiant.
     * L'annotation @Transactional assure que cette opération est exécutée dans une transaction.
     * @param id L'identifiant de l'étudiant à supprimer.
     */
    @Transactional
    public void deleteById(Long id) {
        studentDao.deleteById(id);
    }

    /**
     * Ajoute un nouvel étudiant.
     * L'annotation @Transactional assure que cette opération est exécutée dans une transaction.
     * @param studentDto Le DTO de l'étudiant à ajouter.
     * @throws RuntimeException si une erreur survient lors de la conversion de l'image de l'étudiant.
     */
    @Transactional
    public void addStudent(StudentDto studentDto) {
        Student student;
        try {
            // Convertit le DTO en entité Student. Le second argument 'null' indique qu'il s'agit d'une création.
            student = StudentMapper.fromDto(studentDto, null);
        } catch (IOException e) {
            // Gère les exceptions liées aux opérations d'E/S, potentiellement pour le traitement d'images.
            throw new RuntimeException("Error with Student image", e);
        }

        // Sauvegarde le nouvel étudiant dans la base de données.
        studentDao.save(student);
    }

    /**
     * Met à jour un étudiant existant.
     * L'annotation @Transactional assure que cette opération est exécutée dans une transaction.
     * @param studentDto Le DTO de l'étudiant avec les informations mises à jour.
     * @param id L'identifiant de l'étudiant à mettre à jour.
     * @throws NoSuchElementException si l'étudiant à mettre à jour n'existe pas.
     * @throws RuntimeException si une erreur survient lors de la conversion de l'image de l'étudiant.
     */
    @Transactional
    public void updateStudent(StudentDto studentDto, Long id) {
        // Vérifie si l'étudiant existe avant de tenter une mise à jour.
        studentDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Student student;
        try {
            // Convertit le DTO en entité Student, en passant l'ID pour la mise à jour.
            student = StudentMapper.fromDto(studentDto, id);
        } catch (IOException e) {
            // Gère les exceptions liées aux opérations d'E/S, potentiellement pour le traitement d'images.
            throw new RuntimeException("Error with Student image", e);
        }
        // Sauvegarde les modifications de l'étudiant dans la base de données.
        studentDao.save(student);
    }

    /**
     * Recherche des étudiants par leur filière (major) et leur cours.
     * @param majorId L'identifiant de la filière.
     * @param courseId L'identifiant du cours.
     * @return Une liste d'étudiants correspondant aux critères de recherche.
     */
    public List<Student> searchByMajorAndCourse(int majorId, int courseId) {
        // Appelle la méthode correspondante dans le DAO pour effectuer la recherche.
        return studentDao.findByMajorIdAndCourseId(majorId, courseId);
    }
}