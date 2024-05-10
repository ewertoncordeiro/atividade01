/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ewerton
 */
public class BDVeiculos {

   // private static Passeio[] vetPasseio = new Passeio[5];
    private static Carga[] vetCarga = new Carga[5];
    
    private static Passeio pas;
    private static List<Passeio> bdPas = new ArrayList<Passeio>();
    private static BDVeiculos BDVeiculosUnic;
    
     private BDVeiculos(){
         bdPas = new ArrayList<Passeio>();
       }
      
        public static  BDVeiculos gerarGerpes(){
            if (BDVeiculosUnic == null){
                BDVeiculosUnic = new BDVeiculos();            
        }
          return BDVeiculosUnic;
        }


    public static void setVetCarga(Carga[] vetCarga) {
        BDVeiculos.vetCarga = vetCarga;
    }


    public static Carga[] getVetCarga() {
        return vetCarga;
    }
    
      //busca todos os registros
    	public static void achatodasPlacaPasseio(){
		for(int i = 0; i < bdPas.size(); i++){
                                 imprimePasseio(bdPas.get(i));
                }
	}
      
        public Passeio achaPlacaPasseio(Passeio veiculoPasseio) {
    for (int i = 0; i < bdPas.size(); i++) {
        if (veiculoPasseio.getPlaca().equalsIgnoreCase(bdPas.get(i).getPlaca())) {
           return bdPas.get(i);
        }
    }
    return null;
}

    //delete
    public Passeio removePesCod(Passeio pas) {
        Passeio pas1 = achaPlacaPasseio(pas);
        if (pas1 != null) {
            bdPas.remove(pas1);
            return null;
        } else {
            return pas;
        }
    }

    // insert
    public Passeio cadPas(Passeio pas) throws VeicExistException {
        if (achaPlacaPasseio(pas) == null) {
            bdPas.add(pas);
            return pas;
        } else {
            return null;
        }
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


    public static void achaPlacaVetCarga(Carga veiculoCarga) throws VeicExistException {
        for (int i = 0; i < vetCarga.length; i++) {
            if (vetCarga[i] != null) {
                if (vetCarga[i].getPlaca().equalsIgnoreCase(veiculoCarga.getPlaca())) {
                    throw new VeicExistException();
                }
            }
        }
    }

    public static void imprimePasseio(Passeio passeio) {
        System.out.println("Impressao da placa: " );
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
