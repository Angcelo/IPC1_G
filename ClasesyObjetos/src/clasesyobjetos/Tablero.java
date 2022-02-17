/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesyobjetos;

import java.util.Random;

/**
 *
 * @author angel
 */
public class Tablero {

    private char[][] dimensiones;
    private int[][] noJugadores;
    private int[][][] enlaces;
    private int noEnlaces = 0;

    public void setNoJugadores(int noJugaores) {
        this.noJugadores = noJugadores;
    }

    public int getNoJugadores() {
        return this.noJugadores;
    }

    public Tablero(int dimensiones, int noJugadores) {
        this.noJugadores = new int[noJugadores][2];
        this.dimensiones = new char[dimensiones][dimensiones];
        for (int i = 0; i < dimensiones; i++) {
            for (int j = 0; j < dimensiones; j++) {
                this.dimensiones[i][j] = ' ';
            }
        }
        this.enlaces = new int[10][2][2];
    }

    public void Dibujar() {
        for (int i = 0; i < this.dimensiones.length; i++) {
            for (int j = 0; j < this.dimensiones.length; j++) {
                System.out.print(this.dimensiones[i][j]);
            }
        }
    }

    public void setSerpientes() {
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            int PosX = rnd.nextInt();
            int PosY = rnd.nextInt();
            int PosX2 = rnd.nextInt();
            int PosY2 = rnd.nextInt();
            if (this.dimensiones[PosX][PosY] == ' ') {
                this.dimensiones[PosX][PosY] = '-';
                while (true) {
                    if (this.dimensiones[PosX2][PosY2] == ' ') {
                        this.dimensiones[PosX2][PosY2] = '-';
                        break;
                    }
                }
                if (PosY >= PosY2) {
                    if (PosX > PosX2) {
                        this.enlaces[this.noEnlaces][0][0] = PosX;
                        this.enlaces[this.noEnlaces][0][1] = PosY;
                        this.enlaces[this.noEnlaces][1][0] = PosX2;
                        this.enlaces[this.noEnlaces][1][1] = PosY2;
                    } else {
                        this.enlaces[this.noEnlaces][0][0] = PosX2;
                        this.enlaces[this.noEnlaces][0][1] = PosY2;
                        this.enlaces[this.noEnlaces][1][0] = PosX;
                        this.enlaces[this.noEnlaces][1][1] = PosY;
                    }
                } else {
                    this.enlaces[this.noEnlaces][0][0] = PosX2;
                    this.enlaces[this.noEnlaces][0][1] = PosY2;
                    this.enlaces[this.noEnlaces][1][0] = PosX;
                    this.enlaces[this.noEnlaces][1][1] = PosY;
                }
                this.noEnlaces++;
            }
        }
    }

    public void setEscaleras() {
        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            int PosX = rnd.nextInt();
            int PosY = rnd.nextInt();
            int PosX2 = rnd.nextInt();
            int PosY2 = rnd.nextInt();
            if (this.dimensiones[PosX][PosY] == ' ') {
                this.dimensiones[PosX][PosY] = '+';
                while (true) {
                    if (this.dimensiones[PosX2][PosY2] == ' ') {
                        this.dimensiones[PosX2][PosY2] = '+';
                        break;
                    }
                }
                if (PosY <= PosY2) {
                    if (PosX > PosX2) {
                        this.enlaces[this.noEnlaces][0][0] = PosX;
                        this.enlaces[this.noEnlaces][0][1] = PosY;
                        this.enlaces[this.noEnlaces][1][0] = PosX2;
                        this.enlaces[this.noEnlaces][1][1] = PosY2;
                    } else {
                        this.enlaces[this.noEnlaces][0][0] = PosX2;
                        this.enlaces[this.noEnlaces][0][1] = PosY2;
                        this.enlaces[this.noEnlaces][1][0] = PosX;
                        this.enlaces[this.noEnlaces][1][1] = PosY;
                    }
                } else {
                    this.enlaces[this.noEnlaces][0][0] = PosX2;
                    this.enlaces[this.noEnlaces][0][1] = PosY2;
                    this.enlaces[this.noEnlaces][1][0] = PosX;
                    this.enlaces[this.noEnlaces][1][1] = PosY;
                }
                this.noEnlaces++;
            }
        }
    }

    public void Mover(int noJugador, int numeroaMover) {
        if (noJugadores[noJugador][0] + numeroaMover < this.dimensiones.length) {

        } else {
            int aux = numeroaMover - (this.dimensiones.length - noJugadores[noJugador][0]) - 1;
            noJugadores[noJugador][0] = this.dimensiones.length;
            if (aux >= 0) {
                noJugadores[noJugador][1] += 1;
                noJugadores[noJugador][0] -= aux;
            }
        }
    }
}
