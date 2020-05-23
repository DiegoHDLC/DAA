package procesos;

import java.util.List;

import javax.swing.JLabel;

import vista.Princ;


public class Animaciones {
	public static List<JLabel> a;
	public static void HeapSort(List<JLabel> a) {
		int contador = a.size();
		heapify(a, contador);
		int fi = contador -1;
		while(fi > 0) {
			JLabel tmp = a.get(fi);
			a.set(fi, a.get(0));
			new Thread() {
				@SuppressWarnings("unused")
				public void run(int fi) {
					fi = 10;
					intercambioNumeros(a, 0, fi);
				}
			}.start();
			a.set(0, tmp);
			
			siftDown(a,0,fi - 1);
			fi--;
		}
	}
	
	public static void moverNumero(List<JLabel> a, List<JLabel> tmp, int pos) {
		new Thread() {
			
			int x = a.get(pos-1).getX();
			int y = a.get(pos-1).getY();
			int xTemp = tmp.get(pos).getX();
			int yTemp = tmp.get(pos).getY();
			public void run() {
				System.out.println("xNumero:"+x);
				System.out.println("yNumero:"+y);
				System.out.println("xTemp:"+xTemp);
				System.out.println("yTemp:"+yTemp);
				
				while(y > yTemp) {
					a.get(pos).setLocation(x,y);
					y--;
					System.out.println("yNumero:"+y);
					System.out.println("xNumero:"+x);
					if(y ==yTemp) {
						int x = a.get(pos).getX();
						System.out.println("entra");
						while(x < xTemp) {
							System.out.println("xNumero:"+x);
							a.get(pos).setLocation(x,y);
							x++;
							try {
								Thread.sleep(30);
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
					try {
						Thread.sleep(30);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}.start();
	}
	
	public static void moverNumeroRecto(List<JLabel> a, List<JLabel> tmp, int posIni, int posFin) {
		new Thread() {
			int x1 = a.get(posIni).getX();
			int y1 = a.get(posIni).getY();
			int x2 = tmp.get(posFin).getX();
			int y2 = tmp.get(posFin).getY();
			public void run() {
				System.out.println("entra a moverRecto");
				System.out.println("numero a mover: "+a.get(posIni).getText());
				System.out.println("xNumero:"+x1);
				System.out.println("yNumero:"+y2);
				System.out.println("xTemp:"+x2);
				System.out.println("yTemp:"+y2);
				if(x1 < x2) {
					x1 = a.get(posIni).getX();
					a.get(posIni).setLocation(x1,y1);
					while(x1 < x2) {
						x1--;
						a.get(posIni).setLocation(x1,y1);
					}
					try {
						Thread.sleep(30);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}
		}.start();
	}
	
	public static void moverPrueba(List<JLabel> a,int n1, int n2) {
		System.out.println("entran: "+n1+" y "+n2);
		new Thread() {
			int x1 = a.get(n1).getX();
			int y1 = a.get(n1).getY();
			int x2 = a.get(n2).getX();
			int y2 = a.get(n2).getY();
			int tmp1 = x1;
			int tmp2 = x2; 
			public void run() {
				
				movimientoNumeros(a,x1,y1,x2,y2,n1,n2,tmp2);
			}
		}.start();
		new Thread() {
			
			int x1 = a.get(n1).getX();
			int y1 = a.get(n1).getY();
			int x2 = a.get(n2).getX();
			int y2 = a.get(n2).getY();
			int tmp1 = x1;
			int tmp2 = x2; 
			public void run() {
				movimientoNumeros(a,x2,y2,x1,y1,n1,n2,tmp1);
			}
		}.start();
	}
	public static void movimientoNumeros(List<JLabel> a, int x1, int y1, int x2, int y2, int n1, int n2, int tmp) {
		System.out.println("entran: "+n1+" y "+n2+ "a movimiento numeros");
		
		
		if(x1 < x2) {
			while(x1 < tmp) {
				x1++;
				a.get(n1).setLocation(x1, y1);
				try {
					Thread.sleep(30);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("Numero:"+"["+a.get(n1).getText()+"]"+" Coordenadas:_______________"+x1+","+y1+" Entra al primero");
			}
			
		}
		if(x1 > x2) {
			while(x1 > tmp) {
				x1--;
			}
			a.get(n1).setLocation(x1, y1);
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Numero:"+"["+a.get(n1).getText()+"]"+" Coordenadas:_______________"+x1+","+y1+" Entra al primero");

		}
		
	}
		
			/*
			int valorX1 = a.get(n1).getX();
			int valorY1 = a.get(n1).getY();
			int valorX2 = a.get(n2).getX();
			int tmp2 = valorX2;
			public void run() {
				
				if(valorX1 < valorX2) {
					while(valorX1 < tmp2) {
						valorX1++;
						a.get(n1).setLocation(valorX1, valorY1);
						try {
							Thread.sleep(30);
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out.println("Numero:"+"["+a.get(n1).getText()+"]"+" Coordenadas:_______________"+valorX1+","+valorY1+" Entra al primero");
					}
					
				}
				if(valorX1 > valorX2) {
					while(valorX1 > tmp2) {
						valorX1--;
						a.get(n1).setLocation(valorX1, valorY1);
						try {
							Thread.sleep(30);
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out.println("Numero:"+"["+a.get(n1).getText()+"]"+" Coordenadas:_______________"+valorX1+","+valorY1+" Entra al segundo");
					}
					
				}
			}
		}.start();
		
		new Thread() {
			int valorX1 = a.get(n1).getX();
			int valorX2 = a.get(n2).getX();
			int valorY2 = a.get(n2).getY();
			int tmp1 = valorX1;
			public void run() {
				if(valorX2 < valorX1) {
					while(valorX2 < tmp1) {
						valorX2++;
						a.get(n2).setLocation(valorX2, valorY2);
						try {
							Thread.sleep(30);
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out.println("Numero:"+"["+a.get(n2).getText()+"]"+" Coordenadas:"+valorX2+","+valorY2+" Entra al tercero");
					}
					
				}
				if(valorX2 > valorX1) {
					while(valorX2 > tmp1) {
						valorX2--;
						a.get(n2).setLocation(valorX2, valorY2);
						try {
							Thread.sleep(30);
						} catch (Exception e) {
							// TODO: handle exception
						}
						System.out.println("Numero:"+"["+a.get(n2).getText()+"]"+" Coordenadas:"+valorX2+","+valorY2+" Entra al cuarto");
					}
					
				}
			}
		}.start();
		*/
	
	
	public static void heapify(List<JLabel> a, int contador) {
		int comienzo = (contador - 2)/2;
		while(comienzo >=0) {
			siftDown(a, comienzo, contador -1);
			comienzo--;
		}
	}
	
	public static void siftDown(List<JLabel> a, int comienzo, int fin) {
		int raiz = comienzo;
		
		while((raiz * 2 +1) <= fin) {
			int hijo = raiz * 2 + 1;
			int agetHijo = Integer.parseInt(a.get(hijo).getText());
			int agetHijoSiguiente = Integer.parseInt(a.get(hijo+1).getText());
			if(hijo + 1 <= fin &&  agetHijo < agetHijoSiguiente) {
			hijo++;
			}
			int agetRaiz = Integer.parseInt(a.get(raiz).getText());
			if(agetRaiz < agetHijo){
				JLabel tmp = a.get(hijo);
				a.set(raiz, a.get(hijo));
				a.set(hijo, tmp);
			}else {
				return;
			}
		}
	}
	
	public void detener() {
	    ejecutar = false;
	}
	
	public static void intercambioNumeros(List<JLabel> a, int num1, int num2) {
		
		int num1X = a.get(num1).getX();
		int num1Y = a.get(num1).getY();
		int num2X = a.get(num2).getX();
		if(num1X < num2X) {
			while(ejecutar) {
				while(num1X < num2X) {
					num1X++;
					//num2X--;
					//a.get(num2).setLocation(num2X, num2Y);
					a.get(num1).setLocation(num1X,num1Y);
					try {
						Thread.sleep(5);
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		
	}
	
	volatile static boolean ejecutar = true;
}
