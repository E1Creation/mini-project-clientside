$(document).ready(function () {
  val = 0;
  let select = "";
  $.ajax({
    url: "/api/kelas",
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result[val]);
      let biokelas = `
      <p>Kelas : ${result[val].tingkatan} ${result[val].kode} </p>
      `;
      $("#biokelas").html(biokelas);
      $.each(result, function (i, val) {
        select += `
        <option value=${val.id}>${val.tingkatan} ${val.kode}</option>
        `;
      });
      $("#select-kelas").html(select);
      val = $("#select-kelas").val();
      console.log(val);
    },
  });
  let data = "";
  $.ajax({
    url: "/api/kelas",
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result);
      $.each(result[0].jadwalPelajarans, function (i, val) {
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
  console.log("jalan");
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
