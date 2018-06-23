package io.github.fernandasj.jts.model;

import java.util.Objects;

/**
 *
 * @author fernanda
 */
public class SvgInfo {

    private String path;
    private String color;

    public SvgInfo() {
    }

    public SvgInfo(String path, String color) {
        this.path = path;
        this.color = color;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.path);
        hash = 83 * hash + Objects.hashCode(this.color);
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
        final SvgInfo other = (SvgInfo) obj;
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SvgInfo{" + "path=" + path + ", color=" + color + '}';
    }

}
