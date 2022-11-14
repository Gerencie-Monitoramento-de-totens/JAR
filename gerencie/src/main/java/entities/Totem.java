/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/**
 *
 * @author stefanini
 */
public class Totem {
    private String idTotem;
    private String usuarioTotem;
    private String senhaTotem;
    private Integer limiteProcessador;
    private Integer limiteTemperatura;
    private Integer limiteRam;
    private String isAtivoTotem;
    private Integer fkFastFood;

    public Totem(String idTotem, String usuarioTotem, String senhaTotem, Integer limiteProcessador, Integer limiteTemperatura, Integer limiteRam, String isAtivoTotem, Integer fkFastFood) {
        this.idTotem = idTotem;
        this.usuarioTotem = usuarioTotem;
        this.senhaTotem = senhaTotem;
        this.limiteProcessador = limiteProcessador;
        this.limiteTemperatura = limiteTemperatura;
        this.limiteRam = limiteRam;
        this.isAtivoTotem = isAtivoTotem;
        this.fkFastFood = fkFastFood;
    }

    public String getIdTotem() {
        return idTotem;
    }


    public String getUsuarioTotem() {
        return usuarioTotem;
    }

    public String getSenhaTotem() {
        return senhaTotem;
    }

    public Integer getLimiteProcessador() {
        return limiteProcessador;
    }

    public Integer getLimiteTemperatura() {
        return limiteTemperatura;
    }

    public Integer getLimiteRam() {
        return limiteRam;
    }

    public String getIsAtivoTotem() {
        return isAtivoTotem;
    }

    public void setIsAtivoTotem(String isAtivoTotem) {
        this.isAtivoTotem = isAtivoTotem;
    }

    public Integer getFkFastFood() {
        return fkFastFood;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idTotem);
        hash = 89 * hash + Objects.hashCode(this.usuarioTotem);
        hash = 89 * hash + Objects.hashCode(this.senhaTotem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Totem other = (Totem) obj;
        if (!Objects.equals(this.idTotem, other.idTotem)) {
            return false;
        }
        if (!Objects.equals(this.usuarioTotem, other.usuarioTotem)) {
            return false;
        }
        return Objects.equals(this.senhaTotem, other.senhaTotem);
    }
}
