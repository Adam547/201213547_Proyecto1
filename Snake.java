package snake;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Snake {
    public static int Dato;
    public static int Largo;
    public static String Tabla[][]= new String[50][50];
    public static String Snake[][]= new String[50][50];
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
    public static String L[][]= new String[40][40];
    public static int c;
    public static String N[]= new String[5];
    public static int P[] = new int[5];
    public static int T[] = new int[5];
    public static String temp ="";
    public static String temp4 ="";
    public static int temp2 =0;
    public static int temp5 =0;
    public static int temp3 =0;
    public static int temp6 =0;
    public static int cont;
    public static int ast;
    public static int Tempx[] = new int[100];
    public static int Tempy[] = new int[100];

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Desarrollador();
        
    }

    public static void Desarrollador(){
        Reinicio();
        Menu_Principal();
    }
    
    public static void Creditos(){
       Limpieza();
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
       System.out.println("Carne: 201213547");
       try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
       System.out.println("    Regresando al menu Principal: ");
        for(ast = 0;ast<6;ast++){
         System.out.print("******");
         try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       Desarrollador();
       
    }
    public static void Menu_Principal(){
       Datos_de_Jugadores();
       Limpieza();
       punteo = 0;
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
               Puntuaciones();
               break;
           case 3:
               Creditos();
               break;
           case 4:
               System.exit(0);
               break;
       }
        
    }
    public static void Configuracion(){
       Limpieza();
       System.out.println("Ingrese su nombre:");
       Scanner entrada4 = new Scanner(System.in);
       Nombre = entrada4.nextLine();
       do{
       System.out.println("Ingrese el tamaño del tablero (valor minimo 10 - "
               + "valor maximo 40):");
       Scanner entrada3 = new Scanner(System.in);
       Dato = entrada3.nextInt();
    }while(Dato < 9 || Dato >41 );
       System.out.println("Tamaño con el que iniciara el Snake:");
       Scanner entrada5 = new Scanner(System.in);
       Largo = entrada5.nextInt();
       Tablero();
    }
    public static void Tablero(){
       while(Status != "Game Over"){
       Limpieza();
       Pos_Snake();
       System.out.println("     "+Nombre+"   "+ punteo);
       for (int x=0;x<=Dato;x++){
            for (int y=0;y<=Dato;y++){
               if(y==0 || y==Dato){
                 Tabla[x][y] = " X ";
                 System.out.print(Tabla[x][y]);
                }else{
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
           }
    System.out.println("");
        } 
       Movimiento();
       Puntos();
    }
    Limpieza();
    Game_Over();
    }
   public static void Limpieza(){
  for (int i=0;i<50;i++){
            System.out.println("");
        }
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
            if (Tabla[px][py]== " @ "){
                Status ="Game Over";
            }
            if (Tabla[px][py]== " X "){
                Status ="Game Over";
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
            if (Tabla[px][py]== " @ "){
                Status ="Game Over";
            }
            if (Tabla[px][py]== " X "){
                Status ="Game Over";
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
            if (Tabla[px][py]== " @ "){
                Status ="Game Over";
            }
            if (Tabla[px][py]== " X "){
                Status ="Game Over";
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
            if (Tabla[px][py]== " @ "){
                Status ="Game Over";
            }
            if (Tabla[px][py]== " X "){
                Status ="Game Over";
            }
            Snake[px][py] = " @ ";
            Tabla[px][py] = Snake[px][py];
            System.out.println(px +" "+ py);
            break;
      case"e":
            Status ="Game Over";
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
   public static void Puntos(){
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
   public static void Puntuaciones(){
     Datos_de_Jugadores();
     Limpieza();
     System.out.println("            Puntuaciones                  ");
     System.out.println("  Nombre       Punteo       Tablero");
     System.out.println();
     System.out.println("   "+N[1]+"           "+P[1]+"            "+T[1]+"x"+T[1]);
     System.out.println();
     System.out.println("   "+N[2]+"           "+P[2]+"            "+T[2]+"x"+T[2]);
     System.out.println();
     System.out.println("   "+N[3]+"           "+P[3]+"            "+T[3]+"x"+T[3]);
     System.out.println("    Regresando al menu Principal: ");
        for(ast = 0;ast<6;ast++){
         System.out.print("******");
         try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       Desarrollador();
   }
   public static void Datos_de_Jugadores(){
     cont = cont +1; 
     if (cont <= 3){
        N[1] = "x";
        N[2] = "x";
        N[3] = "x";
        P[1] = 0;
        P[2] = 0;
        P[3] = 0;
        T[1] = 0;
        T[2] = 0;
        T[3] = 0;  
     }else{
     temp4 = temp;
     temp5 = temp2;
     temp6 = temp3;
     temp = N[1];
     temp2 = P[1];
     temp3 = T[1];
     N[1] = Nombre;
     N[2]= temp;
     N[3]= temp4;
     P[1] = punteo;
     P[2] = temp2;
     P[3] = temp5;
     T[1] = Dato;
     T[2] = temp3;
     T[3] = temp6;
     }
   }
   public static void Game_Over(){
       Limpieza();
       System.out.println("xxxxxxxx      x      x       x  xxxxxx");
       System.out.println("x            x x     x x   x x  x");
       System.out.println("x   xxxx    x   x    x   x   x  xxxxxx");
       System.out.println("x      x   xxxxxxx   x       x  x");
       System.out.println("xxxxxxxx  x       x  x       x  xxxxxxx");
       System.out.println();
       System.out.println();
       try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
       System.out.println("xxxxxxxx  x       x  xxxxxx  xxxxxxxx");
       System.out.println("x      x   x     x   x       x      x");
       System.out.println("x      x    x   x    xxxxxx  xxxxxxxxx");
       System.out.println("x      x     x x     x       x     x");
       System.out.println("xxxxxxxx      x      xxxxxxx x       x");
       try {
               TimeUnit.SECONDS.sleep(2);
           } catch (InterruptedException ex) {
               Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
           }
       Desarrollador();
   }
   public static void Reinicio(){
     Status ="";
     for (int x=0;x<=40;x++){
            for (int y=0;y<=40;y++){
                        Tabla[x][y] = " - ";
                        Snake[x][y] = " - ";
                        check = 0;
                        check2 =0;
                        Dato = 0;
                        Largo = 0;
               
            }
        
      }
    }
  }