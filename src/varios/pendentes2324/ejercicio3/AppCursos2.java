package varios.pendentes2324.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppCursos2 {
    public static <T> void main(String[] args) {
        // Crear alumnos
        Alumno alumno1 = new Alumno(1, "Juan");
        Alumno alumno2 = new Alumno(2, "María");
        Alumno alumno3 = new Alumno(3, "Pedro");
        Alumno alumno4 = new Alumno(4, "Laura");
        Alumno alumno5 = new Alumno(5, "Carlos");
        Alumno alumno6 = new Alumno(6, "Ana");
        Alumno alumno7 = new Alumno(7, "Pablo");
        Alumno alumno8 = new Alumno(8, "Sofía");
        Alumno alumno9 = new Alumno(9, "Marta");
        Alumno alumno10 = new Alumno(10, "Alejandro");
        // Crear cursos
        CursoDistancia curso1 = new CursoDistancia(1, "Programación en Java",
                "Aprende a programar en Java", 40,
                LocalDate.of(2024, 7, 1), LocalDate.of(2024, 8, 15), "Moodle");
        CursoPresencial curso2 = new CursoPresencial(2, "Introducción a la Fotografía",
                "Descubre el mundo de la fotografía", 20,
                LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 31), "Aula 101");
        CursoPresencial curso3 = new CursoPresencial(3, "Diseño Gráfico Avanzado",
                "Aprende a utilizar herramientas de diseño", 30,
                LocalDate.of(2024, 9, 1), LocalDate.of(2024, 10, 15), "Aula 202");
        CursoDistancia curso4 = new CursoDistancia(4, "Inglés Intermedio",
                "Mejora tus habilidades en el idioma inglés", 50,
                LocalDate.of(2024, 7, 1), LocalDate.of(2024, 9, 30), "Plataforma Online");
        CursoPresencial curso5 = new CursoPresencial(5, "Marketing Digital",
                "Estrategias de marketing en el entorno digital", 25,
                LocalDate.of(2024, 9, 15), LocalDate.of(2024, 10, 31), "Aula 303");
        CursoDistancia curso6 = new CursoDistancia(6, "Programación Web",
                "Desarrollo de aplicaciones web", 60,
                LocalDate.of(2024, 8, 15), LocalDate.of(2024, 10, 30), "Plataforma Online");
        // Matricular alumnos en los cursos
        curso1.matricularAlumno(alumno1);
        curso1.matricularAlumno(alumno2);
        curso1.matricularAlumno(alumno3);
        curso2.matricularAlumno(alumno4);
        curso2.matricularAlumno(alumno5);
        curso2.matricularAlumno(alumno6);
        curso2.matricularAlumno(alumno7);
        curso3.matricularAlumno(alumno8);
        curso3.matricularAlumno(alumno9);
        curso3.matricularAlumno(alumno10);
        curso4.matricularAlumno(alumno1);
        curso4.matricularAlumno(alumno2);
        curso4.matricularAlumno(alumno6);
        curso4.matricularAlumno(alumno8);
        curso4.matricularAlumno(alumno10);
        curso5.matricularAlumno(alumno1);
        curso5.matricularAlumno(alumno3);
        curso5.matricularAlumno(alumno5);
        curso5.matricularAlumno(alumno7);
        curso5.matricularAlumno(alumno9);
        curso6.matricularAlumno(alumno2);
        curso6.matricularAlumno(alumno4);
        curso6.matricularAlumno(alumno6);
        curso6.matricularAlumno(alumno8);
        curso6.matricularAlumno(alumno10);

        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);

        int opcion = opcionMenu();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    List<Curso> proximosCursos = new ArrayList<>();
                    for (Curso curso : cursos)
                        if (curso.fechaInicio.isAfter(LocalDate.now()))
                            proximosCursos.add(curso);

                    proximosCursos.sort((Curso o1, Curso o2) -> {
                        return o1.fechaInicio.compareTo(o2.fechaInicio);
                    });

                    if (proximosCursos.size() > 0) {
                        for (Curso curso : proximosCursos)
                            System.out.println(curso.id + " - " + curso.nombre + " - " + curso.fechaInicio);
                    } else {
                        System.out.println("No hay próximos cursos");
                    }
                    break;
                case 2:
                    ArrayList<Curso> cursosPorAlumnado = new ArrayList<>();
                        for (Curso curso : cursos) 
                            cursosPorAlumnado.add(curso);

                    cursosPorAlumnado.sort((Curso o1, Curso o2) -> {
                        return o2.numAlumnosMatriculados() - o1.numAlumnosMatriculados();
                    });

                    for (Curso curso : cursosPorAlumnado)
                        System.out.println(curso.id + " - " + curso.nombre + " - " + curso.numAlumnosMatriculados());
                    break;
                case 3:
                    List<Curso> cursosFinalizados = new ArrayList<>();
                    for (Curso curso : cursos)
                        if (curso.fechaFin.isBefore(LocalDate.now()))
                            cursosFinalizados.add(curso);
                    if (cursosFinalizados.size() > 0) {
                        for (Curso curso : cursosFinalizados)
                            System.out.println(curso.id + " - " + curso.nombre + " - " + curso.fechaFin);
                    } else {
                        System.out.println("No hay cursos finalizados.");
                    }

                    break;
                case 4:
                    // Listar alumnos matriculados en los cursos
                    for (Curso curso : cursos)
                        curso.listarAlumnos();
                    break;
            }
            opcion = opcionMenu();
        }

    }

    static int opcionMenu() {
        System.out.println("1. Próximos cursos");
        System.out.println("2. Cursos por Alumnado");
        System.out.println("3. Cursos Finalizados");
        System.out.println("4. Detalle de cursos");
        System.out.println("0. SALIR");

        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        while (opcion < 0 || opcion > 4) {
            try {
                opcion = sc.nextInt();
                if (opcion < 0 || opcion > 4)
                    System.out.println("Opción incorrecta: sólo se permiten valores entre 0 y 4");
            } catch (Exception e) {
                System.out.println("Opción incorrecta: sólo se permiten números enteros");
                sc.nextLine();
            }
        }
        // sc.close();
        return opcion;

    }

}
