package com.example.a41615045.ultimojuegoandroid;

import android.util.Log;

import org.cocos2d.actions.interval.ScaleBy;
import org.cocos2d.layers.Layer;
import org.cocos2d.nodes.Director;
import org.cocos2d.nodes.Label;
import org.cocos2d.nodes.Scene;
import org.cocos2d.nodes.Sprite;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.CCPoint;
import org.cocos2d.types.CCSize;

/**
 * Created by 41615045 on 27/9/2016.
 */
public class clsJuego {

    CCGLSurfaceView _VistaDelJuego;
    CCSize PantallaDelDispositivo;
    Sprite ImagenFondo;
    Sprite Jugador;

    Label lblTextoJuego;
    int a;

    public clsJuego(CCGLSurfaceView VistaDelJuego) {

        Log.d("Bob", "Comienza el constructor de la clase");
        _VistaDelJuego=VistaDelJuego;
    }
    public void ComenzarJuego(){
        Log.d("Comenzar", "Comienza el juego");
        Director.sharedDirector().attachInView(_VistaDelJuego);

        PantallaDelDispositivo=Director.sharedDirector().displaySize();
        Log.d("Comenzar", "Pantalla del dispositivo - ancho:"+PantallaDelDispositivo.width+ " - alto: " +PantallaDelDispositivo.height);


        Director.sharedDirector().runWithScene(EscenaDelJuego());

    }
    private Scene EscenaDelJuego(){
        Log.d("EscenaDelJuego", "Comienza el armado de escena");

        Log.d("EscenaDelJuego", "Declaro e instancio la escena del juego en si");
        Scene EscenaADevolver;
        EscenaADevolver=Scene.node();

        Log.d("EscenaDelJuego", "Declaro e instancio la capa que va a contener la imagen de fondo");
        CapaDeFondo MiCapaFondo=new CapaDeFondo();
        CapaFrente MiCapaFrente =new CapaFrente();

        Log.d("EscenaDelJuego", "Declaro e instancio la capa que va a contener el jugador y a los enemigos");
        EscenaADevolver.addChild(MiCapaFondo, -10);
        EscenaADevolver.addChild(MiCapaFrente, 10);

        Log.d("EscenaDelJuego", "Devuelvo la escena ya armada");
        return EscenaADevolver;
    }

    class CapaDeFondo extends Layer {
        public CapaDeFondo(){
            Log.d("CapaDelFondo", "Comienza el constructor de la capa del fondo");

            Log.d("CapaDelFondo", "Pongo la imagen del fondo del juego");
            PonerImagenFondo();

        }
        private void PonerImagenFondo() {
            Log.d("PonerImagenFondo", "Comienzo a poner la imagn del fondo");

            Log.d("PonerImagenFondo", "Instancio el sprite");
            ImagenFondo=Sprite.sprite("fondo.png");

            Log.d("PonerImagenFondo", "La ubico en el centro de la pantalla");
            ImagenFondo.setPosition(PantallaDelDispositivo.width/2, PantallaDelDispositivo.height/2);

            Log.d("PonerImagenFondo", "Agrando la imagen el doble de su tamaño actual");



            Log.d("PonerImagenFondo", "La agrego a la capa");
            super.addChild(ImagenFondo);
        }
    }

    class CapaFrente extends Layer {

        public CapaFrente() {

            Log.d("Capa del frente", "Comienza el constructor de la capa del frente");

            Log.d("CapaDelFrente", "Pongo al jugador en su posicion inicial");
     //       PonerNaveJugadorPosicionInicial();

        }

   /*     private void PonerNaveJugadorPosicionInicial() {
            Log.d("PonerJugador", "Comienzo a poner la nave del jugador en su posicion inicial");

            Log.d("PonerJugador", "Instancio el sprite");
            Jugador = Sprite.sprite("jugador.png");

            float PosicionInicialX, PosicionInicialY;
            PosicionInicialX=PantallaDelDispositivo.width/2;
            PosicionInicialY=PantallaDelDispositivo.height/2;

            Log.d("PonerNaveJugador", "Obtengo la mitad de la altura de la nave");
            PosicionInicialY=Jugador.getHeight()/2;

            Log.d("PonerNaveJugador", "Lo ubico en X: "+PosicionInicialX+" - Y :"+PosicionInicialY);
            Jugador.setPosition(PosicionInicialX, PosicionInicialY);

            // Log.d("PonerNaveJugador", "Pongo mi nave en una posicion cualquiera");
            // NaveJugador.setPosition(100, 300);

            Log.d("NaveJugador", "Agrego la nave a la capa");
            super.addChild(Jugador);
        }
*/
        private void PonerTituloJuego() {

            Log.d("PonerTituloJuego", "Comienza a poner el titulo");
            lblTextoJuego=Label.label("Super mega juegazo", "Verdana", 30);

            float AltoDelTitulo;
            AltoDelTitulo=lblTextoJuego.getHeight();

            lblTextoJuego.setPosition(PantallaDelDispositivo.width/2, PantallaDelDispositivo.height=AltoDelTitulo/2);
            super.addChild(lblTextoJuego);
        }


  /*      void PonerUnEnemigo(){

            Log.d("PonerEnemigo", "Instancio el sprite del enemigo");



            Log.d("PonerEnemigo", "Determino la posicion inicial");
            CCPoint PosicionInicial;
            PosicionInicial = new CCPoint();

            Log.d("PonerEnemigo", "La posicion Y es arriba de toda la pantalla, totalmente afuera");


            Log.d("PonerEnemigo", "La posicion Y es arriba de toda la pantalla"+PosicionInicial.y);



           Log.d("PonerEnemigo", "La posicion X es en el centro"+PosicionInicial.x);

            Log.d("PonerEnemigo", "Declaro e inicialo el generador de azar");


            Log.d("PonerEnemigo", "La posicion X es al azar");


            Log.d("PonerEnemigo", "La ubico en la posicion que determine");



        }
    */
    }
}
