$(document).ready(function () {
  $.ajax({
    url: "/api/entitas/count",
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result);
      $("#jumlah-guru").html(result.jumlah_guru);
      $("#jumlah-siswa").html(result.jumlah_siswa);
      $("#jumlah-matapelajaran").html(result.jumlah_mata_pelajaran);
    },
  });
});
