package com.example.aplicationTest.entities;

import jakarta.persistence.*;


@Entity
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String type;

    @Lob
    @Column(nullable = false,columnDefinition = "LONGBLOB")
    byte[] data;

    @Column(nullable = true)
    String type2;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data2;


    @Column(nullable = true)
    String type3;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data3;

    @Column(nullable = true)
    String type4;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data4;

    @Column(nullable = true)
    String type5;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data5;
    @Column(nullable = true)
    String type6;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data6;
    @Column(nullable = true)
    String type7;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data7;
    @Column(nullable = true)
    String type8;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data8;
    @Column(nullable = true)
    String type9;

    @Lob
    @Column(nullable = true,columnDefinition = "LONGBLOB")
    byte[] data9;


    public void setData2(byte[] data2) {
        this.data2 = data2;
    }

    public void setData3(byte[] data3) {
        this.data3 = data3;
    }

    public void setData4(byte[] data4) {
        this.data4 = data4;
    }

    public void setData5(byte[] data5) {
        this.data5 = data5;
    }

    public void setData6(byte[] data6) {
        this.data6 = data6;
    }

    public void setData7(byte[] data7) {
        this.data7 = data7;
    }

    public void setData8(byte[] data8) {
        this.data8 = data8;
    }

    public void setData9(byte[] data9) {
        this.data9 = data9;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public void setType5(String type5) {
        this.type5 = type5;
    }

    public void setType6(String type6) {
        this.type6 = type6;
    }

    public void setType7(String type7) {
        this.type7 = type7;
    }

    public void setType8(String type8) {
        this.type8 = type8;
    }

    public void setType9(String type9) {
        this.type9 = type9;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public byte[] getData2() {
        return data2;
    }

    public byte[] getData3() {
        return data3;
    }

    public byte[] getData4() {
        return data4;
    }

    public byte[] getData5() {
        return data5;
    }

    public byte[] getData6() {
        return data6;
    }

    public byte[] getData7() {
        return data7;
    }

    public byte[] getData8() {
        return data8;
    }

    public byte[] getData9() {
        return data9;
    }

    public String getType2() {
        return type2;
    }

    public String getType3() {
        return type3;
    }

    public String getType4() {
        return type4;
    }

    public String getType5() {
        return type5;
    }

    public String getType6() {
        return type6;
    }

    public String getType7() {
        return type7;
    }

    public String getType8() {
        return type8;
    }

    public String getType9() {
        return type9;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

}
