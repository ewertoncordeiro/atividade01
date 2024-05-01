/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atividade01;

import java.io.IOException;

/**
 *
 * @author Ewerton teste comit
 */
public class Teste {

    private static Passeio veiculoPasseio = new Passeio();
    private static Carga veiculoCarga = new Carga();
    private static final Leitura l = new Leitura();

    public static void main(String args[]) throws IOException, VeicExistException, VelocException {

        Passeio[] vetPasseio = BDVeiculos.getVetPasseio();
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
            System.out.println("\t7 - Sair");

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

                    for (int i = BDVeiculos.achaVetPasseio(vetPasseio); i < vetPasseio.length; i++) {
                        if (i == -1) {
                            l.entDados("Vetor Passeio cheio. Press enter para voltar ao menu");
                            break;
                        }
                        try {
                            veiculoPasseio = new Passeio();
                            veiculoPasseio.setPlaca(l.entDados("Placa:"));
                            BDVeiculos.achaPlacaVetPasseio(veiculoPasseio);

                            vetPasseio[i] = cadastroPasseio(veiculoPasseio);

                            l.entDados("Cadastro ok posicao " + i + ". Press enter para continuar");
                            String op = l.entDados("Deseja cadastrar outro veiculo de passeio? s/n");
                            if (op.equalsIgnoreCase("n")) {
                                break;
                            }
                            if (BDVeiculos.achaVetPasseio(vetPasseio) == -1) {
                                l.entDados("Vetor passeio cheio, press enter");
                                break;
                            }
                        } catch (VeicExistException ve) {
                            break;
                        }
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

                            String op = l.entDados("Deseja cadastrar outro veiculo de Carga? s/n");
                            if (op.equalsIgnoreCase("n")) {
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
                    for (int i = 0; i < vetPasseio.length; i++) {
                        if (vetPasseio[i] != null) {
                            BDVeiculos.imprimePasseio(vetPasseio[i], i);
                        } else {
                            l.entDados("Fim da lista de impressao, press enter");
                            break;
                        }
                    }
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

                    boolean existePlaca = false;
                    String placaPesquisa = l.entDados("Informe a placa para pesquisa:");
                    veiculoPasseio.setPlaca(placaPesquisa);
                    for (int i = 0; i < vetPasseio.length; i++) {
                        if (vetPasseio[i] != null) {
                            if (vetPasseio[i].getPlaca().equalsIgnoreCase(veiculoPasseio.getPlaca())) {
                                BDVeiculos.imprimePasseio(vetPasseio[i], i);
                                existePlaca = true;
                            }
                        }
                    }
                    if (!existePlaca) {
                        l.entDados("Placa nao localizada");
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
                    continuar = false;
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }
    }

    private static Passeio cadastroPasseio(Passeio veiculoPasseio) throws VelocException {

        boolean continuar = true;
        while (continuar) {
            try {
                veiculoPasseio.setMarca(l.entDados("Marca: "));
                veiculoPasseio.setModelo(l.entDados("Modelo:"));
                veiculoPasseio.setCor(l.entDados("Cor:"));
                try {
                    veiculoPasseio.setVelocMax(Float.parseFloat(l.entDados("Velocidade max.:")));
                } catch (VelocException ve) {
                    veiculoPasseio.setVelocMax((100));
                }
                veiculoPasseio.setQtdRodas(Integer.parseInt(l.entDados("Qtd Rodas:")));
                veiculoPasseio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia:")));
                veiculoPasseio.getMotor().setQtdPist(Integer.parseInt(l.entDados("Qtd pist.:")));
                veiculoPasseio.setQtdPassageiros(Integer.parseInt(l.entDados("Qtd passageiros.:")));
                continuar = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Apenas numeros inteiros nos atributos numericos. Reiniciando cadastro");
            } 
        }
        return veiculoPasseio;
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
