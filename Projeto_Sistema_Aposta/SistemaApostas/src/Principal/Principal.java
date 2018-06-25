package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.ApostaDAO;
import DAO.ApostadorDAO;
import DAO.JogoDAO;
import pojo.Aposta;
import pojo.Apostador;
import pojo.Jogo;

public class Principal {

	public static void main(String[] args) {
		ApostadorDAO apostadorDAO = new ApostadorDAO();
		ApostaDAO apostaDAO = new ApostaDAO();
		JogoDAO jogoDAO = new JogoDAO();
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		ArrayList<Aposta> apostas = new ArrayList<Aposta>();
		ArrayList<Apostador> apostadores = new ArrayList<Apostador>();
		int opcao;
		Scanner scanner = new Scanner(System.in);
		//   scanner.useLocale(Locale.ENGLISH);
		boolean fim = false;

		while(!fim) {


			System.out.println("| 1 | Cadastrar Apostador");
			System.out.println("| 2 | Exibir Apostadores");
			System.out.println("| 3 | Deletar Apostador");
			System.out.println("| 4 | Atualizar Apostador");
			System.out.println("| 5 | Fazer Aposta");
			System.out.println("| 6 | Buscar Apostador");
			System.out.println("| 7 | Adicionar Jogo");
			System.out.println("| 8 | Exibir Aposta");
			System.out.println("| 9 | Resultado Jogos");
			System.out.println("| 10| Conferir Apostas");

			System.out.println("| 0 | Sair");
			System.out.print("Digite a sua opção ~> ");



			opcao = scanner.nextInt();
			scanner.nextLine();




			switch(opcao) {
			case 0:{
				System.out.println("Saindo....");
				fim = true;
				break;
			}

			case 1: {
				int idApostador;
				String nome;

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Digite o nome do Apostador: ");
				nome = scanner.nextLine();
				System.out.println("Digite uma id para o Apostador: ");
				idApostador = scanner.nextInt();

				Apostador apostador = new Apostador(idApostador, nome,0,0);
				apostadores = apostadorDAO.listaApostadores();
				for(int i=0;i<apostadores.size();i++) {
					if(apostadores.get(i).getId_apostador() == idApostador) {
						System.out.println("Erro | Esse id já existe...");
					}else {

						if (apostadorDAO.addApostador(apostador)) {
							System.out.println("Apostador Inserido com sucesso!");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						} else {
							System.err.println("Erro ao inserir!");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
						} 


					}
				}



				break;
			}
			case 2: {
				apostadores = apostadorDAO.listaApostadores();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				for (Apostador a : apostadores) {
					System.out.println(a);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}

				break;
			}
			case 3: {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Digite o número do apostador que deseja deletar: ");
				int id = scanner.nextInt(); //recuperar esse id pelo nome
				if(apostadorDAO.deleteApostador(id)) {
					System.out.println("Apostador Deletado com sucesso!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				} else {
					System.err.println("Erro ao deletar!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
				break;
			}
			case 4: {
				int id_apostador;//recuperar esse id pelo nome
				String nome;
				double ganho;
				int pontos;

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Digite o número do cliente que deseja atualizar: ");
				id_apostador = scanner.nextInt();//recuperar esse id pelo nome
				System.out.println("Digite seu novo nome: ");
				nome = scanner.next();
				System.out.println("Digite os saldo do cliente: ");
				ganho = scanner.nextDouble();
				System.out.println("Digite os pontos cliente: ");
				pontos = scanner.nextInt();

				Apostador apostador = new Apostador(id_apostador, nome, ganho, pontos);

				if(apostadorDAO.atualizarApostador(apostador)){
					System.out.println("Apostador atualizado com sucesso!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				} else {
					System.err.println("Erro ao atulizar!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}

				break;
			}
			case 5:{
				System.out.println("Digite a ID do Apostador: ");//recuperar esse id pelo nome
				int id_apostador = scanner.nextInt();//recuperar esse id pelo nome
				//fazer mostrar os jogos;
				System.out.println("Digite a ID do Jogo");
				int id_jogo= scanner.nextInt();
				System.out.println("Digite a ID da Aposta");
				int id_aposta = scanner.nextInt();
				System.out.println("Ganhador do jogo... Time Casa(V) Time Fora(p)");
				String resultado = scanner.next();
				System.out.println("Gols da partida: ");
				System.out.println("Ex: 7|1");
				String gols = scanner.next();

				Aposta aposta = new Aposta(id_aposta, gols,resultado,id_jogo,id_apostador);

				System.out.println(aposta);

				if (apostaDAO.realizarAposta(aposta)) {
					System.out.println("Aposta inserida com sucesso!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				} else {
					System.err.println("Erro ao inserir aposta!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				} 
				break;
			}


			case 6:{
				System.out.println("Digite a ID do Apostador: ");//recuperar esse id pelo nome
				int id = scanner.nextInt();//recuperar esse id pelo nome

				if(apostadorDAO.buscarApostador(id)==null) {
					System.out.println("Erro | ID não encontrada!!!");
				}else {
					System.out.println(apostadorDAO.buscarApostador(id));
				}

				break;

			}

			case 7:{
				System.out.println("Digite a id do jogo:");
				int id_jogo = scanner.nextInt();
				System.out.println("Digite o nome do time da Casa:");
				String time1 = scanner.next();
				System.out.println("Digite o nome do time de Fora:");
				String time2 = scanner.next();
				System.out.println("Digite o placar do jogo:");
				String placar = scanner.next();


				Jogo jogo = new Jogo(time1, time2, placar, id_jogo);


				if(jogoDAO.addJogo(jogo)){
					System.out.println("Jogo adicionado com sucesso!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				} else {
					System.err.println("Erro ao adicionar!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}

				break;
			}
			case 8:{
				apostas = apostaDAO.listaApostas();

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				for (Aposta a : apostas) {
					System.out.println(a);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
				break;
			}


			case 9:{
				jogos = jogoDAO.listaJogos();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				for (Jogo jogo : jogos) {
					System.out.println(jogo);
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
				break;
			}
			case 10: {
				System.out.println("Conferindo Apostas....");
				apostas = apostaDAO.listaApostas();
				jogos = jogoDAO.listaJogos();
				if(apostas.size()>0) {
					if(jogos.size()>0) {
						for(Jogo jogo : jogos) {
							for(Aposta a : apostas) {
								if(a.getGols().equals(jogo.getPlacar())) {
									apostadorDAO.buscarApostador(a.getId_apostador());
									//implementar essa parte...
									//para aumentar os pontos dos apostadores
									System.out.println("Ganhador: "+apostadorDAO.buscarApostador(a.getId_apostador()));
								}
							}
						}

					}else {
						System.out.println("Erro | Nao existe jogos cadastrados!!!");
					}
				}else {
					System.out.println("Erro | Nao existe apostas cadastradas!!!");
				}

				break;
			}



			}
		}
	}
}

