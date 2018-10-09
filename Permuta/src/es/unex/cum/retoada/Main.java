package es.unex.cum.retoada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();

		//Lo primero es leer lo introducido por teclado
		Scanner s = new Scanner (System.in);
		
		String lista [] = new String [6];
		for (int i=0; i<6; i++) {
			String entrada = s.nextLine();
			lista [i] = entrada;
		}
		//Ya tengo las lineas cogidas.
		m.permuta(lista);
		s.close();
	}

	public void permuta (String lista []) {
		for (int i=0; i<6; i++) {
			String palabro1 = lista[i];
			i++;
			String palabro2 = lista[i];
			ArrayList <Character> letras = comparar(palabro1, palabro2);
			Iterator it = letras.iterator();
			while (it.hasNext()) {
				char l = (char) it.next();
				System.out.print(l);
			}
			System.out.println();
		}
	}
	
	public ArrayList <Character> comparar (String p1, String p2){
		ArrayList <Character> lista1 = new ArrayList <Character>();
		for (int i=0; i<p1.length(); i++) {
			char letra1 = p1.charAt(i);
			int j = 0;
			while (j<p2.length()) {
				char letra2 = p2.charAt(j);
				if (letra1 == letra2) lista1.add(letra1);
				j++;
			}
		}
		ArrayList <Character> lista2 = new ArrayList <Character>();
		for (int i=0; i<p2.length(); i++) {
			char letra1 = p2.charAt(i);
			int j = 0;
			boolean ya = false;
			while (j<p1.length() && !ya) {
				char letra2 = p1.charAt(j);
				if (letra1 == letra2) {
					lista2.add(letra1);
					ya = true;
				}
				j++;
			}
		}
		
		Iterator it1 = lista1.iterator();
		Iterator it2 = lista2.iterator();
		char l1 = (char) it1.next();
		char l2 = (char) it2.next();
		if (l1 < l2) return lista1;
		else return lista2;
	}
}
