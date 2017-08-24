
package snake;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Snake {
    public String salida;
    public String menu2;
    public int menu;
    public static int Dato;
    public static int Largo;
    public static String Tabla[][]= new String[40][40];
    public static String Snake[][]= new String[40][40];
    public static int max;
    public static int check;
    public static int check2;
    public static boolean check3;
    public static boolean check4;
    public static String Status;
    public static String Nombre;
    public static int px;
    public static int py;
    public static int cx;
    public static int cy;
    public static int punteo;
    public static String L[][]= new String[50][50];
    public static int c;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Desarrollador();
        
    }

    public static void Desarrollador(){
        Menu_Principal();
    }
    
    public static void Creditos(){
       System.out.println("Hecho por:");
        try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
       System.out.println("Adam Jose Miguel Navas Garcia");
        try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
       System.out.println("*****************************");
        try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
       System.out.println("Ingrese e para regresar al menu principal");
       Scanner entrada = new Scanner(System.in);
       String menu2 = entrada.nextLine();
       if (menu2=="e"){
       Desarrollador();
       }
    }
    public static void Menu_Principal(){
       System.out.println("xxxxxxxx  x     x      x      x    x  xxxxxx");
       System.out.println("x         x  x  x     x x     x  x    x");
       System.out.println("xxxxxxxx  x   x x    x   x    xx      xxxxxx");
       System.out.println("       x  x    xx   xxxxxxx   x  x    x");
       System.out.println("xxxxxxxx  x     x  x       x  x    x  xxxxxx");
       System.out.println();
       System.out.println();
       System.out.println("     1) iniciar el juego");
       System.out.println();
       System.out.println("     2) Puntuaciones");
       System.out.println();
       System.out.println("     3) Creditos");
       System.out.println();
       System.out.println("     4) Salir");
       System.out.println("Ingrese el numero para ver cada menu:");
       Scanner entrada = new Scanner(System.in);
       int menu =0;
       menu = entrada.nextInt();
       switch(menu){
           case 1:
               Configuracion();
               break;
           case 2:
               System.out.println("puntuaciones");
           case 3:
               Creditos();
               break;
           case 4:
               System.out.println("salir");
       }
        
    }
    public static void Configuracion(){
       System.out.println("Ingrese su nombre:");
       Scanner entrada4 = new Scanner(System.in);
       Nombre = entrada4.nextLine();
       System.out.println("Ingrese el tamaño del tablero (valor minimo 10 - "
               + "valor maximo 50):");
       Scanner entrada3 = new Scanner(System.in);
       Dato = entrada3.nextInt();
       System.out.println("Tamaño con el que iniciara el Snake:");
       Scanner entrada5 = new Scanner(System.in);
       Largo = entrada5.nextInt();
       Tablero();
    }
    public static void Tablero(){
       while(Status != "Game Over"){
       Pos_Snake();
       System.out.println("     "+Nombre+"   "+ punteo);
       for (int x=0;x<=Dato;x++){
           for (int y=0;y<=Dato;y++){
               if(x==0 || x==Dato){
                 Tabla[x][y] = " X ";
                 System.out.print(Tabla[x][y]);
                }else{
                   
                 if (Tabla[x][y]== " @ " || Tabla[cx][cy] == " ■ "){
                   System.out.print(Tabla[x][y]);
                 }else{   
                   Tabla[x][y] = " - ";
                   System.out.print(Tabla[x][y]);
                 }
                }
              
           }
    System.out.println("");
        } 
       Movimiento();
       Puntuacion();
    }
    Menu_Principal();
    }
   public static void Limpieza(){
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   System.out.println();
   }
   public static void Pos_Snake(){
    check = check +1; 
    if (check == 1){
        for(int m = 1; m <= Largo; m++){   
            Snake[5][m] = " @ ";
            Tabla[5][m] = Snake[5][m];
            px = 5;
            py = m;
            check4 = true;
        }
     }
   }
   public static void Movimiento(){
      Comida();
      Scanner entrada7 = new Scanner(System.in);
      String move = entrada7.nextLine(); 
      System.out.println("este dato se ingreso;"+move);
      switch(move){   
      case"a":
            py = py - 1;
            if (Tabla[px][py]== " ■ "){
                check3 = true;
            }
            Snake[px][py] = " @ ";
            Tabla[px][py] = Snake[px][py];
            System.out.println(px +" "+ py);
            break;
      case"d":
            py = py + 1;
            if (Tabla[px][py]== " ■ "){
                check3 = true;
            }
            Snake[px][py] = " @ ";
            Tabla[px][py] = Snake[px][py];
            System.out.println(px +" "+ py);
            break;
        
      case"w":
            px = px - 1;
            if (Tabla[px][py]== " ■ "){
                check3 = true;
            }
            Snake[px][py] = " @ ";
            Tabla[px][py] = Snake[px][py];
            System.out.println(px +" "+ py);
            break;
      case"s":
            px = px + 1;
            if (Tabla[px][py]== " ■ "){
                check3 = true;
            }
            Snake[px][py] = " @ ";
            Tabla[px][py] = Snake[px][py];
            System.out.println(px +" "+ py);
            break;    
        }
   }
   
   public static void Comida(){
       check2 = check2+1;
       while(check2==1){
           cx = (int)(Math.random()* Dato);
           cy = (int)(Math.random()* Dato);
           if(Tabla[cx][cy]!= " X " && Tabla[cx][cy]!= " @ "){
           check2 = 2;
           Tabla[cx][cy] =" ■ ";
       }
       }
   }
   public static void Puntuacion(){
      if(check3 == true){
          check3 = false;
          check2 = 0;
          if (cx < cy){
          punteo = punteo + Math.abs((Dato/2)-cy);
          }else{
          punteo = punteo + Math.abs((Dato/2)-cx);
          }
      }
   }
   public static void Control_Snake(){
       if(check4 == true){ 
         for (int h = 0;h==5;h++){   
           L[1][c+1]= Snake[1][c+1];
            c = c+1;
         }
       check4 = false;
            if (check3 == true){
              c = c+1;
              for(int S = 0;S == c;S++){
                  
              }
            }
      }
   }
}
