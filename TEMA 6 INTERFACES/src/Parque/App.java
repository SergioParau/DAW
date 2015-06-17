package Parque;

import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AreaProtegida cabarceno = new AreaProtegida(75, "Cab�rceno", 60, "EAZA", 7000000);
		AreaProtegidaAcuatica donyana = new AreaProtegidaAcuatica(300, "Do�ana", 300,"Parques Naturales", 15000000, 300);
		AreaProtegidaTerrestre ordesa = new AreaProtegidaTerrestre(150, "Parque Nacional de Ordesa y Monte Perdido", 150, "Parques Naturales", 5000000, "Monta�oso");
		ReservaCaza cotoValencia = new ReservaCaza(30, "Coto privado Hnos.Mor�n", 5, "Escopeta", 560);
		ReservaCaza cotoToledo = new ReservaCaza(120, "Coto privado Toledano", 16, "Rifle", 1300);
		
		final ArrayList <Parque> listaParques = new ArrayList <Parque>();
		
		listaParques.add(cotoToledo);
		listaParques.add(cabarceno);
		listaParques.add(donyana);
		listaParques.add(cotoValencia);
		listaParques.add(ordesa);
		
		for(Parque parque:listaParques){
			System.out.println(parque);
		}
		
		
		for(Parque parqueVisitable:listaParques){
			if(parqueVisitable instanceof AreaProtegida){
				System.out.println(((AreaProtegida) parqueVisitable).visitar());
			}
		}
		
		
		
		
		
	}

}