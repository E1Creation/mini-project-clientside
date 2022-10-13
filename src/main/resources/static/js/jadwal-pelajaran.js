$(document).ready(function () {
  let initialValue = 1;
  let select = "";
  $.ajax({
    url: "/api/kelas",
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result[0]);
      let biokelas = `
      <p>Kelas : ${result[0].tingkatan} ${result[0].kode} </p>
      `;
      $("#biokelas").html(biokelas);
      $.each(result, function (i, val) {
        select += `
        <option value=${val.id}>${val.tingkatan} ${val.kode}</option>
        `;
      });
      $("#select-kelas").html(select);
    },
  });
  console.log("jalan");
  getKelasById();
});
function getKelasById() {
  let data = "";
  $.ajax({
    url: "/api/kelas/" + 1,
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result);
      $.each(result.jadwalPelajarans, function (i, val) {
        console.log(val);
        data += `
            <tr>
              <td>${i + 1}</td>
              <td>${val.mataPelajarans.nama}</td>
              <td>${val.hari}</td>
              <td>${val.jamMasuk}</td>
              <td>${val.jamKeluar}</td>
            </tr>
          `;
      });
      $("#table-jadwal-pelajaran").html(data);
    },
  });
}
$("#select-kelas").on("change", () => {
  let data = "";
  $.ajax({
    url: "/api/kelas/" + $("#select-kelas").val() ?? 1,
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result);
      let biokelas = `
      <p>Kelas : ${result.tingkatan} ${result.kode} </p>
      `;
      $("#biokelas").html(biokelas);
      $.each(result.jadwalPelajarans, function (i, val) {
        console.log(val);
        data += `
            <tr>
              <td>${i + 1}</td>
              <td>${val.mataPelajarans.nama}</td>
              <td>${val.hari}</td>
              <td>${val.jamMasuk}</td>
              <td>${val.jamKeluar}</td>
            </tr>
          `;
      });
      $("#table-jadwal-pelajaran").html(data);
    },
  });
});

// $("#table-manage-user").DataTable({
//   ajax: {
//     url: "/api/kelas",
//     dataSrc: "",
//   },
//   columns: [
//     {
//       data: null,
//       render: (data, type, row, meta) => {
//         return meta.row + 1;
//       },
//     },
//     {
//       data: "mataPelajarans.nama",
//     },
//     {
//       data: "tingkatan",
//     },
//     {
//       data: "kode",
//     },
//     {
//       data: "user.isAccountLocked",
//     },
//     {
//       data: "user.isEnabled",
//     },
//     {
//       data: null,
//       render: (data, type, row, meta) => {
//         return `
//                         <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailRegion" onclick="findById(${data.id})">
//                         Detail
//                         </button>

//                         <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateRegion" onclick="beforeUpdate(${data.id})">
//                         Update
//                         </button>

//                          <button type="button" class="btn btn-danger" onclick="deleteRegion(${data.id})">
//                         Delete
//                         </button>
//                     `;
//       },
//     },
//   ],
// });
