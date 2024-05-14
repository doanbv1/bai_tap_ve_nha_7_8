package com.Ph31058.bai_tap_ve_nha_78

class Studen (
    var name: String,
    var old: Int,
    var lop: String,
)

class Card( val maPhieuMuon: String, val ngayMuon: Int, val hanTra: Int, val soHieuSach: Int, val sinhVien: Studen)

class Qlcard {
    var listCard = mutableListOf<Card>();

    fun addCard (card: Card) {
        listCard.add(card)
    }

    fun deleteCard (idCard: String): Boolean{
        val deleteCarById = listCard.find { it.maPhieuMuon == idCard }
        if (deleteCarById != null){
            listCard.remove(deleteCarById)
            println("Da xoa")
            return true
        }else{
            println("Khong tim thay ma")
            return false
        }
    }

    fun showInforCard () {

        if (listCard.isEmpty()){
            println("Danh sach Card Rong")
        }else{
            listCard.forEach {
                println("idCar: ${it.maPhieuMuon} " +
                        "Ngay muon: ${it.ngayMuon} " +
                        "Ngay tra: ${it.hanTra} " +
                        "So hieu sach: ${it.soHieuSach}" +
                        "Ten SV: ${it.sinhVien.name}" +
                        "Tuoi : ${it.sinhVien.old}" +
                        "Lop : ${it.sinhVien.lop}")
            }
        }

    }
}

fun main () {
    println("Phan mem quan ly thu vien chao ban:")
    var qlcard = Qlcard()

    var studen1 = Studen("Nguyen Van B",18,"ANDROID")
    var studen2 = Studen("Nguyen Van C",28,"ANDROID")
    var studen3 = Studen("Bui Van Doan", 30,"Android")

    var card3 = Card("MP003",2,3,111,studen3);
    var car1 = Card("MP001",1,2,321,studen1)
    var car2 = Card("MP002",1,2,321,studen2)

    qlcard.addCard(car1)
    qlcard.addCard(car2)
    qlcard.addCard(card3)

//    qlcard.deleteCard("MP002")
    qlcard.showInforCard()

}