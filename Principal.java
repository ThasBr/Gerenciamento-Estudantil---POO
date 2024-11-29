import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    // Listas para armazenar estudantes, professores e cursos
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Limpar a tela para melhorar a experiência do usuário
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Exibe o menu principal do sistema
            System.out.println("=== Sistema de Gerenciamento Estudantil ===");
            System.out.println("1. Menu Alunos");
            System.out.println("2. Menu Professores");
            System.out.println("3. Menu Cursos");
            System.out.println("4. Gerar Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println();
            // Redireciona para o menu correspondente
            switch (opcao) {
                case 1:
                    menuAluno(scanner);
                    break;
                case 2:
                    menuProfessor(scanner);
                    break;
                case 3:
                    menuCurso(scanner);
                    break;
                case 4:
                    gerarRelatorios(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...\n\n\n");
                    break;
                default:
                    System.out.println("Opção inválida!\n");
            }
        } while (opcao != 0); // Continua exibindo o menu enquanto o usuário não escolher sair

        scanner.close(); // Fecha o scanner ao final do programa
    }

    // Menu de gerenciamento de alunos
    private static void menuAluno(Scanner scanner) {
        int opcao;
        do {
            // Pausa para o usuário
            System.out.println("\nPressione Enter para continuar...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Limpar a tela antes de exibir o menu de alunos
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("=== Menu Aluno ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Consultar Aluno");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println();
            // Processa a escolha do usuário
            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner); // Chama o método de cadastro de aluno
                    break;
                case 2:
                    consultarAluno(scanner); // Chama o método de consulta de aluno
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0); // Continua no menu enquanto o usuário não escolher voltar
        System.out.println();
    }

    // Método para cadastrar um novo aluno
    private static void cadastrarAluno(Scanner scanner) {
        // Solicita os dados do aluno
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do Aluno: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Matrícula do Aluno: ");
        String matricula = scanner.nextLine();

        // Cria o objeto Aluno e adiciona à lista
        Aluno aluno = new Aluno(nome, idade, matricula);
        alunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!\n");
    }

    // Método para consultar dados de um aluno específico
    private static void consultarAluno(Scanner scanner) {
        // Solicita o critério de busca
        System.out.print("Digite o nome ou matrícula do aluno: ");
        String busca = scanner.nextLine().trim();

        // Procura o aluno na lista
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(busca) || aluno.getMatricula().equalsIgnoreCase(busca)) {
                aluno.exibirDados(); // Exibe os dados do aluno encontrado

                // Menu de ações adicionais para o aluno encontrado
                System.out.println("\nO que deseja fazer?");
                System.out.println("1. Editar");
                System.out.println("2. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                if (opcao == 1) {
                    editarAluno(scanner, aluno); // Chama o método de edição
                } else if (opcao == 2) {
                    alunos.remove(aluno); // Remove o aluno da lista
                    System.out.println("Aluno excluído com sucesso!");
                }
                System.out.println();
                return;
            }
        }

        System.out.println("\nAluno não encontrado.\n");
    }

    // Método para editar os dados de um aluno
    private static void editarAluno(Scanner scanner, Aluno aluno) {
        // Solicita os novos dados do aluno
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        // Atualiza os dados do objeto aluno
        aluno.setNome(nome);
        aluno.setIdade(idade);

        System.out.println("\nDados do aluno atualizados com sucesso!\n");
    }

    // Menu de gerenciamento de professores
    private static void menuProfessor(Scanner scanner) {
        int opcao;
        do {
            // Pausa para o usuário
            System.out.println("\nPressione Enter para continuar...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Limpar a tela para melhorar a visualização do menu
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Exibição do menu professores
            System.out.println("=== Menu Professor ===");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Consultar Professor");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (opcao) {
                case 1:
                    // Chama a função para cadastrar um novo professor
                    cadastrarProfessor(scanner);
                    break;
                case 2:
                    // Chama a função para consultar um professor pelo nome
                    consultarProfessor(scanner);
                    break;
                case 0:
                    // Sai do menu de professor
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    // Caso o usuário escolha uma opção inválida
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0); // Repete até o usuário escolher "Voltar"
        System.out.println();
    }

    // Função para cadastrar um novo professor
    private static void cadastrarProfessor(Scanner scanner) {
        System.out.print("Nome do Professor: ");
        String nome = scanner.nextLine(); // Captura o nome do professor
        System.out.print("Especialidade do Professor: ");
        String especialidade = scanner.nextLine(); // Captura a especialidade

        // Cria um objeto Professor com os dados fornecidos
        Professor professor = new Professor(nome, 0, especialidade); // Idade não usada aqui
        professores.add(professor); // Adiciona à lista de professores

        System.out.println("\nProfessor cadastrado com sucesso!\n");
    }

    // Função para consultar informações de um professor pelo nome
    private static void consultarProfessor(Scanner scanner) {
        System.out.print("Digite o nome do professor: ");
        String busca = scanner.nextLine(); // Captura o nome para busca

        // Busca a lista de professores para encontrar o correspondente
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(busca)) {
                // Exibe os dados do professor encontrado
                professor.exibirDados();

                System.out.println("\nO que deseja fazer?");
                System.out.println("1. Editar");
                System.out.println("2. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                if (opcao == 1) {
                    // Permite editar os dados do professor
                    editarProfessor(scanner, professor);
                } else if (opcao == 2) {
                    // Remove o professor da lista
                    professores.remove(professor);
                    System.out.println("Professor excluído com sucesso!");
                }
                System.out.println();
                return; // Finaliza após encontrar o professor
            }
        }

        // Caso o professor não seja encontrado
        System.out.println("Professor não encontrado.\n");
    }

    // Função para editar os dados de um professor
    private static void editarProfessor(Scanner scanner, Professor professor) {
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine(); // Captura o novo nome
        System.out.print("Nova Especialidade: ");
        String especialidade = scanner.nextLine(); // Captura a nova especialidade

        // Atualiza os dados do professor
        professor.setNome(nome);
        professor.setEspecialidade(especialidade);

        System.out.println("Dados do professor atualizados com sucesso!\n");
    }

    // Menu de gerenciamento de cursos
    private static void menuCurso(Scanner scanner) {
        int opcao;
        do {
            // Pausa para o usuário
            System.out.println("\nPressione Enter para continuar...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Limpar a tela para o usuário
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Exibição do menu cursos
            System.out.println("=== Menu Curso ===");
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Consultar Curso");
            System.out.println("3. Vincular Estudantes/Professores");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (opcao) {
                case 1:
                    // Chama a função para cadastrar um novo curso
                    cadastrarCurso(scanner);
                    break;
                case 2:
                    // Chama a função para consultar os dados de um curso
                    consultarCurso(scanner);
                    break;
                case 3:
                    // Chama a função para vincular estudantes ou professores a um curso
                    vincularCurso(scanner);
                    break;
                case 0:
                    // Sai do menu de curso
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    // Mensagem de erro para opção inválida
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0); // Repete até o usuário escolher "Voltar"
        System.out.println();
    }

    // Função para cadastrar um novo curso
    private static void cadastrarCurso(Scanner scanner) {
        // Solicita ao usuário o nome do curso
        System.out.print("Nome do Curso: ");
        String nome = scanner.nextLine();
        // Solicita ao usuário a carga horária do curso
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine(); 

        // Cria um novo objeto Curso com as informações fornecidas
        Curso curso = new Curso(nome, cargaHoraria, null);
        // Adiciona o curso à lista de cursos
        cursos.add(curso);
        System.out.println("\nCurso cadastrado com sucesso!\n");
    }

    // Função para consultar um curso cadastrado
    private static void consultarCurso(Scanner scanner) {
        // Solicita ao usuário o nome do curso a ser consultado
        System.out.print("Digite o nome do curso: ");
        String busca = scanner.nextLine();

        // Busca a lista de cursos para encontrar o curso desejado
        for (Curso curso : cursos) {
            if (curso.getNomeCurso().equalsIgnoreCase(busca)) {
                // Exibe os dados do curso
                curso.exibirDados();

                // Verifica se há um professor associado ao curso
                Professor professor = curso.getProfessor();
                if (professor != null) {
                    // Se houver professor, exibe seus dados
                    System.out.println(
                            "Professor: " + professor.getNome() + " - Especialidade: " + professor.getEspecialidade());
                } else {
                    // Caso não haja professor, informa ao usuário
                    System.out.println("Professor: Nenhum professor associado.");
                }

                // Oferece opções para editar, excluir ou voltar
                System.out.println("\nO que deseja fazer?");
                System.out.println("1. Editar");
                System.out.println("2. Excluir");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                if (opcao == 1) {
                    // Se escolher editar, chama a função de editar o curso
                    editarCurso(scanner, curso);
                } else if (opcao == 2) {
                    // Se escolher excluir, remove o curso da lista
                    cursos.remove(curso);
                    System.out.println("Curso excluído com sucesso!");
                }
                System.out.println();
                return;
            }
        }

        // Caso o curso não seja encontrado
        System.out.println("\nCurso não encontrado.\n");
    }

    // Função para editar um curso existente
    private static void editarCurso(Scanner scanner, Curso curso) {
        // Solicita os novos dados para o curso
        System.out.print("Novo Nome do Curso: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        // Atualiza as informações do curso
        curso.setNomeCurso(nome);
        curso.setCargaHoraria(cargaHoraria);

        // Confirma que o curso foi atualizado com sucesso
        System.out.println("\nDados do curso atualizados com sucesso!\n");
    }

    // Função para vincular estudantes ou professores a cursos
    private static void vincularCurso(Scanner scanner) {
        System.out.println("Opções de vinculação:");
        System.out.println("1. Associar Estudantes");
        System.out.println("2. Associar Professores");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println();
        if (opcao == 1) {
            // Se escolher associar estudantes, chama a função para isso
            associarEstudantes(scanner);
        } else if (opcao == 2) {
            // Se escolher associar professores, chama a função para isso
            associarProfessores(scanner);
        } else if (opcao == 0) {
            // Se escolher voltar, retorna
            return;
        } else {
            // Caso a opção seja inválida
            System.out.println("Opção inválida.");
        }
        System.out.println();
    }

    // Função para associar estudantes a um curso
    private static void associarEstudantes(Scanner scanner) {
        // Solicita o nome do curso para buscar
        System.out.print("Digite o nome do curso: ");
        String buscaCurso = scanner.nextLine();

        // Verifica se o curso existe
        Curso curso = null;
        for (Curso c : cursos) {
            if (c.getNomeCurso().equalsIgnoreCase(buscaCurso)) {
                curso = c;
                break;
            }
        }

        if (curso == null) {
            // Caso o curso não seja encontrado
            System.out.println("\nCurso não encontrado.");
            return;
        }

        // Solicita a matrícula do estudante para associar
        System.out.print("Digite a matrícula do estudante: ");
        String buscaEstudante = scanner.nextLine();

        // Verifica se o estudante existe
        for (Aluno estudante : alunos) {
            if (estudante.getMatricula().equalsIgnoreCase(buscaEstudante)) {
                // Se o estudante for encontrado, associa ao curso
                estudante.cadastrarCurso(curso);
                System.out.println("\nEstudante associado ao curso com sucesso!");
                return;
            }
        }
        // Caso o estudante não seja encontrado
        System.out.println("\nEstudante não encontrado.");
    }

    // Função para associar professores a um curso
    private static void associarProfessores(Scanner scanner) {
        // Solicita o nome do curso para buscar
        System.out.print("Digite o nome do curso: ");
        String buscaCurso = scanner.nextLine();

        // Verifica se o curso existe
        Curso curso = null;
        for (Curso c : cursos) {
            if (c.getNomeCurso().equalsIgnoreCase(buscaCurso)) {
                curso = c;
                break;
            }
        }

        if (curso == null) {
            // Caso o curso não seja encontrado
            System.out.println("\nCurso não encontrado.");
            return;
        }

        // Solicita o nome do professor para associar
        System.out.print("Digite o nome do professor: ");
        String buscaProfessor = scanner.nextLine();

        // Verifica se o professor existe
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(buscaProfessor)) {
                // Se o professor for encontrado, associa ao curso
                curso.setProfessor(professor);
                System.out.println("\nProfessor associado ao curso com sucesso!");
                return;
            }
        }

        // Caso o professor não seja encontrado
        System.out.println("\nProfessor não encontrado.");
    }

    // Função para gerar relatórios de estudantes e professores
    private static void gerarRelatorios(Scanner scanner) {
        int opcao;
        do {
            // Pausa para o usuário
            System.out.println("\nPressione Enter para continuar...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Limpar a tela
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Exibe as opções de relatórios
            System.out.println("=== Relatórios ===");
            System.out.println("1. Relatório de Estudantes");
            System.out.println("2. Relatório de Professores");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            System.out.println();
            switch (opcao) {
                case 1:
                    // Se escolher relatório de estudantes, gera o relatório
                    gerarRelatorioEstudantes();
                    break;
                case 2:
                    // Se escolher relatório de professores, gera o relatório
                    gerarRelatorioProfessores();
                    break;
                case 0:
                    // Se escolher voltar, retorna
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    // Caso a opção seja inválida
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        System.out.println();
    }

    // Função para gerar relatório de estudantes
    private static void gerarRelatorioEstudantes() {
        System.out.println("=== Relatório de Estudantes ===");
        // Exibe os dados de cada estudante e os cursos matriculados
        for (Aluno estudante : alunos) {
            estudante.exibirDados();
            System.out.println("Cursos matriculados:");
            for (Curso curso : estudante.getCursos()) {
                System.out.println("- " + curso.getNomeCurso());
            }
            System.out.println("-------------------------");
        }
    }

    // Função para gerar relatório de professores
    private static void gerarRelatorioProfessores() {
        System.out.println("=== Relatório de Professores ===");
        // Exibe os dados de cada professor e os cursos associados
        for (Professor professor : professores) {
            professor.exibirDados();
            System.out.println("Cursos associados:");
            for (Curso curso : cursos) {
                if (curso.getProfessor() != null && curso.getProfessor().equals(professor)) {
                    System.out.println("- " + curso.getNomeCurso());
                }
            }
            System.out.println("-------------------------");
        }
    }
}
