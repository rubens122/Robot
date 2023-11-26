package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    private Coordenada coordenada;
    private Orientacion orientacion;
    private Zona zona;

    public Robot(){
        zona = new Zona();
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }
    public Robot(Zona zona){
        this();
        setZona(zona);
        coordenada = zona.getCentro();
    }
    public Robot(Zona zona, Orientacion orientacion){
        this(zona);
        setOrientacion(orientacion);
    }
    public Robot(Zona zona, Orientacion orientacion,Coordenada coordenada){
        this(zona,orientacion);
        setCoordenada(coordenada);
    }
    public Robot(Robot robot){
        Objects.requireNonNull(robot,"El robot no puede ser nulo.");
        zona = robot.zona;
        orientacion = robot.orientacion;
        coordenada = robot.coordenada;
    }
    public Zona getZona(){
        return zona;
    }
    private void setZona(Zona zona){
        this.zona = Objects.requireNonNull(zona,"La zona no puede ser nula.");
    }
    public Orientacion getOrientacion(){
        return orientacion;
    }
    private void setOrientacion(Orientacion orientacion){
        this.orientacion = Objects.requireNonNull(orientacion,"La orientación no puede ser nula.");
    }
    public Coordenada getCoordenada(){
        return coordenada;
    }
    private void setCoordenada(Coordenada coordenada){
        Objects.requireNonNull(coordenada,"La coordenada no puede ser nula.");
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.coordenada = coordenada;
    }
    public void avanzar() throws OperationNotSupportedException {
        int nuevaX = coordenada.x();
        int nuevaY = coordenada.y();
        switch (orientacion) {
            case NORTE -> nuevaY += 1;
            case NORESTE -> {
                nuevaY++;
                nuevaX++;
            }
            case ESTE -> nuevaX++;
            case SURESTE -> {
                nuevaY--;
                nuevaX++;
            }
            case SUR -> nuevaY--;
            case SUROESTE -> {
                nuevaY--;
                nuevaX--;
            }
            case OESTE -> nuevaX--;
            case NOROESTE -> {
                nuevaY++;
                nuevaX--;
            }
        }
        try {
            setCoordenada(new Coordenada(nuevaX,nuevaY));
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }

    }
    public void girarALaDerecha(){
        orientacion = switch (orientacion){
            case NORTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.NORTE;
        };
    }
    public void girarALaIzquierda(){
        orientacion = switch(orientacion){
            case NORTE -> Orientacion.NOROESTE;
            case NORESTE -> Orientacion.NORTE;
            case ESTE -> Orientacion.NORESTE;
            case SURESTE -> Orientacion.ESTE;
            case SUR -> Orientacion.SURESTE;
            case SUROESTE -> Orientacion.SUR;
            case OESTE -> Orientacion.SUROESTE;
            case NOROESTE -> Orientacion.OESTE;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion && Objects.equals(zona, robot.zona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, orientacion, zona);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordenada=" + coordenada +
                ", orientacion=" + orientacion +
                ", zona=" + zona +
                '}';
    }
}
