package mate.academy.mapstruct.mapper;

import mate.academy.mapstruct.dto.student.CreateStudentRequestDto;
import mate.academy.mapstruct.dto.student.StudentDto;
import mate.academy.mapstruct.dto.student.StudentWithoutSubjectsDto;
import mate.academy.mapstruct.model.Student;
import mate.academy.mapstruct.model.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {GroupMapper.class, SubjectMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentDto toDto(Student student);

    StudentWithoutSubjectsDto toStudentWithoutSubjectsDto(Student student);

    Student toModel(CreateStudentRequestDto requestDto);

    default Subject idToSubject(Long id) {
        Subject subject = new Subject();
        subject.setId(id);
        return subject;
    }
}