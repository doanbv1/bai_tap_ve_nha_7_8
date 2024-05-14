package com.Ph31058.bai_tap_ve_nha_78

data class Person (
    val name: String,
    val homeTown: String,
    val old: Int
)


data class CBGV(

    val perSon: Person,
    val id:String,
    var hardSalay : Double,
    var salaryAndBonus : Double,
    var fine : Double,

) {
    var foodSalary : Double = 0.0
    private set

    fun calculateFoodSalary () {
        foodSalary = hardSalay + salaryAndBonus - fine
    }
}

 class QLGV  {
    private var listCBGV = mutableListOf<CBGV>()

    fun addGV (cbgv: CBGV): Boolean {
        if (listCBGV.any {it.id  == cbgv.id}){
            println("ID Giang Vien da ton tai")
            return false
        }else{
            listCBGV.add((cbgv))
            return true
        }

    }

    fun deleteCBGV(maSoGiaoVien: String): Boolean {
        val cbgvCanXoa = listCBGV.find { it.id == maSoGiaoVien }
        return if (cbgvCanXoa != null) {
            listCBGV.remove(cbgvCanXoa)
            println("Da xoa")
            true
        } else {
            println("Khong tim thay ma giang vien ")
            false // Không tìm thấy cán bộ giáo viên với mã số đã cho
        }
    }

    fun showListGV () {
        if (listCBGV.isEmpty()){
            println("danh sach giang vien rong")
        }else{
            println("Danh sach giang vien")
            listCBGV.forEach {
                println("Id: ${it.id} " +
                        "Tên: ${it.perSon.name} " +
                        "Tuổi: ${it.perSon.old} " +
                        "Quê quán: ${it.perSon.homeTown}, " +
                        "Lương cứng: ${it.hardSalay}, " +
                        "Lương thưởng: ${it.salaryAndBonus} " +
                        "Phạt : ${it.fine}")
            }
        }
    }

}

fun main () {
    println("Chao Mung Ban Den Phan Men Quan LY Giang Vien")
    var QuanLyGiangVien = QLGV()

    var person = Person("Nguyen Van A","Ha Noi", 20);
    var person2 = Person("Nguyen Van B","Ha Noi", 20);

    var cbgv = CBGV(person,"GV001",30300.0,2000.0,1000.0)



    var cbgv2 = CBGV(person2,"GV002",3000.0,2000.0,1000.0)
    cbgv2.calculateFoodSalary()
    println("Luong thuc cua nhan vien 1 {${cbgv2.foodSalary}}")
    QuanLyGiangVien.addGV(cbgv)
    QuanLyGiangVien.addGV(cbgv2)

//    QuanLyGiangVien.deleteCBGV("GV001")


    QuanLyGiangVien.showListGV();

}