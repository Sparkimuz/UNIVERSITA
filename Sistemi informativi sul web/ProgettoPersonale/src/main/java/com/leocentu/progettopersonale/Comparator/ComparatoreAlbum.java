package com.leocentu.progettopersonale.Comparator;

import java.util.Comparator;

import com.leocentu.progettopersonale.model.Album;

public class ComparatoreAlbum implements Comparator<Album> {
        @Override
        public int compare(Album o1, Album o2) {
            return (int) (o1.getId() - o2.getId());
        }
}