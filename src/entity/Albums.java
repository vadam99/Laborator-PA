/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author vadam
 */
@Entity
@Table(name = "ALBUMS")
@NamedQueries({
    @NamedQuery(name = "Albums.findAll", query = "SELECT a FROM Albums a"),
    @NamedQuery(name = "Albums.findById", query = "SELECT a FROM Albums a WHERE a.id = :id"),
    @NamedQuery(name = "Albums.findByName", query = "SELECT a FROM Albums a WHERE a.name = :name"),
    @NamedQuery(name = "Albums.findByReleaseYear", query = "SELECT a FROM Albums a WHERE a.releaseYear = :releaseYear"),
    @NamedQuery(name = "Albums.findByArtist", query = "SELECT a FROM Albums a WHERE a.artistId= :artistId")})
public class Albums implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "RELEASE_YEAR")
    private BigInteger releaseYear;
    @JoinColumn(name = "ARTIST_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Artists artistId;

    public Albums() {
    }

    public Albums(BigDecimal id) {
        this.id = id;
    }

    public Albums(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(BigInteger releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artists getArtistId() {
        return artistId;
    }

    public void setArtistId(Artists artistId) {
        this.artistId = artistId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Albums)) {
            return false;
        }
        Albums other = (Albums) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Albums[ id=" + id + " ]";
    }
    
}
