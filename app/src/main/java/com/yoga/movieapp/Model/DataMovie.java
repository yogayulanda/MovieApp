package com.yoga.movieapp.Model;

public class DataMovie implements IDataMovie{
    String judul,deskripsi,rating,vote,waktu,poster;

    public DataMovie() {
    }

    public DataMovie(String judul, String deskripsi, String rating, String vote, String waktu, String poster) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.rating = rating;
        this.vote = vote;
        this.waktu = waktu;
        this.poster = poster;
    }

    @Override
    public String getJudul() {
        return judul;
    }

    @Override
    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String getRating() {
        return rating;
    }

    @Override
    public String getVote() {
        return vote;
    }

    @Override
    public String getWaktu() {
        return waktu;
    }

    @Override
    public String getPoster() {
        return poster;
    }
}
