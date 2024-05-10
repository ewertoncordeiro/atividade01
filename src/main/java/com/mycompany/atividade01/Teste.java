/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atividade01;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ewerton teste comit
 */
public class Teste {

    private static Passeio veiculoPasseio = new Passeio();
    private static Carga veiculoCarga = new Carga();
    private static final Leitura l = new Leitura();
    private static BDVeiculos bdpass = BDVeiculos.gerarGerpes();

    public static void main(String args[]) throws IOException, VeicExistException, VelocException {

        //  Passeio[] vetPasseio = BDVeiculos.getVetPasseio();
        Carga[] vetCarga = BDVeiculos.getVetCarga();
        boolean continuar = true;
        int opcao = 0;

        while (continuar) {

            System.out.println("\t\t ----MENU----");
            System.out.println("\t1 - Cadastrar veiculo de passeio");
            System.out.println("\t2 - Cadastrar veiculo de carga");
            System.out.println("\t3 - Imprimir Todos os Veiculos de Passeio");
            System.out.println("\t4 - Imprimir Todos os Veiculos de Carga");
            System.out.println("\t5 - Imprimir Veiculo de Passeio pela Placa");
            System.out.println("\t6 - Imprimir Veiculo de Carga pela Placa");
            System.out.println("\t7 - Imprimir Veiculo de Carga pela Placa");
            System.out.println("\t9 - Sair");

            try {
                opcao = Integer.parseInt(l.entDados("Selecione um item:"));
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros");
                l.entDados("");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro do veiculo de Passeio:");

                    veiculoPasseio = new Passeio();
                   cadastroPasseio(veiculoPasseio);
                    l.entDados("Cadastro ok posicao press enter para continuar");
                    String op = l.entDados("Deseja cadastrar outro veiculo de Carga? s/n");
                            if (op.equalsIgnoreCase("n")) {
                                break;
                  
                   }
                   break;

                case 2:

                    System.out.println("Cadastro do veiculo de carga:");
                    for (int i = BDVeiculos.achaVetCarga(vetCarga); i < vetCarga.length; i++) {
                        if (i == -1) {
                            l.entDados("Vetor Carga cheio. Press enter para voltar ao menu");
                            break;
                        }
                        try {
                            veiculoCarga = new Carga();
                            veiculoCarga.setPlaca(l.entDados("Placa:"));
                            BDVeiculos.achaPlacaVetCarga(veiculoCarga);

                            vetCarga[i] = cadastroCarga(veiculoCarga);

                            l.entDados("Cadastro ok posicao " + i + " press enter para continuar");

                            String op2 = l.entDados("Deseja cadastrar outro veiculo de Carga? s/n");
                            if (op2.equalsIgnoreCase("n")) {
                                break;
                            }
                            if (BDVeiculos.achaVetCarga(vetCarga) == -1) {
                                l.entDados("Vetor carga cheio, press enter");
                                break;
                            }
                        } catch (VeicExistException ve) {
                            break;
                        }
                    }
                    break;

                case 3:

                    System.out.println("Impressao dos veiculos de passeio");
                    
                    BDVeiculos.achatodasPlacaPasseio();
                    
                    break;

                case 4:

                    System.out.println("Impressao dos veiculos de carga");
                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i] != null) {
                            BDVeiculos.imprimeCarga(vetCarga[i], i);
                        } else {
                            l.entDados("Fim da lista de impressao, press enter");
                            break;
                        }
                    }
                    break;

                case 5:

                    System.out.println("Consulta veiculo de passeio por placa");
                    veiculoPasseio = new Passeio();
                    
                    veiculoPasseio.setPlaca(l.entDados("Placa:"));
                    veiculoPasseio = bdpass.achaPlacaPasseio(veiculoPasseio);
                     if (veiculoPasseio != null) {
                   BDVeiculos.imprimePasseio(veiculoPasseio);

                } else {
                    l.entDados("Veiculo nao localizado");
                }
                   
                    break;

                case 6:

                    System.out.println("Consulta veiculo de carga por placa");
                    veiculoCarga = new Carga();

                    boolean existePlacaC = false;
                    String placaPesquisaC = l.entDados("Informe a placa para pesquisa:");
                    veiculoCarga.setPlaca(placaPesquisaC);
                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i] != null) {
                            if (vetCarga[i].getPlaca().equalsIgnoreCase(veiculoCarga.getPlaca())) {
                                BDVeiculos.imprimeCarga(vetCarga[i], i);
                                existePlacaC = true;
                            }
                        }
                    }
                    if (!existePlacaC) {
                        l.entDados("Placa nao localizada");
                    }
                    break;

                case 7:

                    veiculoPasseio = new Passeio();
                    veiculoPasseio.setPlaca(l.entDados("Informe a placa para exclusao:"));
                    veiculoPasseio = bdpass.removePesCod(veiculoPasseio);
                    if (veiculoPasseio == null) {
                        l.entDados("Veiculo excluido com sucesso");
                    } else {
                        l.entDados("Veiculo nao encontrado");
                    }

                    break;

                case 9:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    public static boolean cadastroPasseio(Passeio veiculoPasseio) throws VelocException, VeicExistException {

        boolean continuar = true;
        while (continuar) {
            try {
                veiculoPasseio.setPlaca(l.entDados("Placa:"));
             //   veiculoPasseio.setMarca(l.entDados("Marca: "));
             //   veiculoPasseio.setModelo(l.entDados("Modelo:"));
             //   veiculoPasseio.setCor(l.entDados("Cor:"));
            //    try {
             //       veiculoPasseio.setVelocMax(Float.parseFloat(l.entDados("Velocidade max.:")));
             //   } catch (VelocException ve) {
             //       veiculoPasseio.setVelocMax((100));
             //   }
            //    veiculoPasseio.setQtdRodas(Integer.parseInt(l.entDados("Qtd Rodas:")));
           //    veiculoPasseio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia:")));
            //    veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd pist.:")));
            //    veiculoPasseio.setQtdPassageiros(Integer.parseInt(l.entDados("Qtd passageiros.:")));
                veiculoPasseio = bdpass.cadPas(veiculoPasseio);
                continuar = false;

                if (veiculoPasseio != null) {
                    l.entDados("Veiculo passeio incluido. Press enter");
                   
                } else {
                    l.entDados("Veiculo ja existente. Press enter para reiniciar");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros nos atributos numericos. Reiniciando cadastro");
            }
        }
        return true;
    }

    private static Carga cadastroCarga(Carga veiculoCarga) throws VelocException {

        boolean continuar = true;
        while (continuar) {
            try {
                veiculoCarga.setMarca(l.entDados("Marca:"));
                veiculoCarga.setModelo(l.entDados("Modelo:"));
                veiculoCarga.setCor(l.entDados("Cor:"));
                try {
                    veiculoCarga.setVelocMax(Float.parseFloat(l.entDados("Velocidade max.:")));
                } catch (VelocException ve) {
                    veiculoCarga.setVelocMax(90);
                }
                veiculoCarga.setQtdRodas(Integer.parseInt(l.entDados("Qtd Rodas:")));
                veiculoCarga.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia:")));
                veiculoCarga.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd Pist.:")));
                veiculoCarga.setCargaMax(Integer.parseInt(l.entDados("Carga max..:")));
                veiculoCarga.setTara(Integer.parseInt(l.entDados("Tara..:")));
                continuar = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros nos atributos numericos. Reiniciando cadastro");
            }
        }
        return veiculoCarga;
    }

}
