/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

/**
 *
 * @author Ewerton
 */
public class BDVeiculos {

    private static Passeio[] vetPasseio = new Passeio[5];
    private static Carga[] vetCarga = new Carga[5];

    public static void setVetPasseio(Passeio[] vetPasseio) {
        BDVeiculos.vetPasseio = vetPasseio;
    }

    public static void setVetCarga(Carga[] vetCarga) {
        BDVeiculos.vetCarga = vetCarga;
    }

    public static Passeio[] getVetPasseio() {
        return vetPasseio;
    }

    public static Carga[] getVetCarga() {
        return vetCarga;
    }

    //verificar posicao dos vetores
    public static int achaVetPasseio(Passeio[] vetP) {
        for (int i = 0; i < vetP.length; i++) {
            if (vetP[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public static int achaVetCarga(Carga[] vetCarga) {
        for (int i = 0; i < vetCarga.length; i++) {
            if (vetCarga[i] == null) {
                return i;
            }
        }
        return -1;
    }

    //verificador de placa
    public static void achaPlacaVetPasseio(Passeio veiculoPasseio) throws VeicExistException {
        for (int i = 0; i < vetPasseio.length; i++) {
            if (vetPasseio[i] != null) {
                if (vetPasseio[i].getPlaca().equalsIgnoreCase(veiculoPasseio.getPlaca())) {
                    throw new VeicExistException();
                }
            }
        }
    }

    public static void achaPlacaVetCarga(Carga veiculoCarga) throws VeicExistException {
        for (int i = 0; i < vetCarga.length; i++) {
            if (vetCarga[i] != null) {
                if (vetCarga[i].getPlaca().equalsIgnoreCase(veiculoCarga.getPlaca())) {
                    throw new VeicExistException();
                }
            }
        }
    }

    public static void imprimePasseio(Passeio passeio, int i) {
        System.out.println("Posicao do Vetor:" + i);
        System.out.println("Marca........" + passeio.getMarca());
        System.out.println("Modelo......." + passeio.getModelo());
        System.out.println("Placa........" + passeio.getPlaca());
        System.out.println("Velocidade..." + passeio.getVelocMax());
        System.out.println("Cor.........." + passeio.getCor());
        System.out.println("Qtd Rodas...." + passeio.getQtdRodas());
        System.out.println("Passageitos.." + passeio.getQtdPassageiros());
        System.out.println("Potencia....." + passeio.getMotor().getPotencia());
        System.out.println("Pistoes......" + passeio.getMotor().getQtdPist());
        System.out.println("Qtd caracteres......" + passeio.calcular());
        passeio.calcVel();
        System.out.println("-------------------------");
    }

    public static void imprimeCarga(Carga carga, int i) {
        System.out.println("Posicao do Vetor:" + i);
        System.out.println("Marca........" + carga.getMarca());
        System.out.println("Modelo......." + carga.getModelo());
        System.out.println("Placa........" + carga.getPlaca());
        System.out.println("Velocidade..." + carga.getVelocMax());
        System.out.println("Cor.........." + carga.getCor());
        System.out.println("Qtd Rodas...." + carga.getQtdRodas());
        System.out.println("Carga maxima." + carga.getCargaMax());
        System.out.println("Tara........." + carga.getTara());
        System.out.println("Potencia....." + carga.getMotor().getPotencia());
        System.out.println("Pistoes......" + carga.getMotor().getQtdPist());
        System.out.println("Soma dos valores ......" + carga.calcular());
        carga.calcVel();
        System.out.println("-------------------------");
    }

}
