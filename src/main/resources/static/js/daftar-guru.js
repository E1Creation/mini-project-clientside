// $(document).ready(function () {
//   console.log(name);
//   $.ajax({
//     url: "/api/entitas/role/2",
//     method: "GET",
//     contentType: "application/json",
//     dataType: "json",
//     success: (result) => {
//       // console.log(result);
//       let data = ``;
//       $.each(result, function (i, val) {
//         data += `
//         <tr>
//         <td >${val.nama}</td>
//         <td >${val.nomorInduk}</td>
//         <td>${val.email}</td>
//         <td>${val.alamat}</td>
//         <td>${val.noHp}</td>
//         <td sec:authorize="hasRole('ADMIN')">
//           <button
//             class="btn btn-primary btn-s"
//             data-title="EditGuru"
//             data-bs-toggle="modal"
//             data-bs-target="#edit-guru"
//             id="editGuru-list"
//           >
//             Edit
//           </button>
//           <button class="btn btn-danger" id="delete-guru" onclick="deleteById(${val.user.id})">
//             Delete
//           </button>
//         </td>
//       </tr>;`;
//       });
//       $("#daftar-guru").html(data);
//     },
//   });
// });
function showInputData(id) {
  $.ajax({
    url: "/api/entitas/" + id,
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: (result) => {
      console.log(result);
      $("#nip").val(result.nomorInduk);
      $("#nama").val(result.nama);
      $("#email").val(result.email);
      $("#alamat").val(result.alamat);
      $("#kontak").val(result.noHp);
      $("#id-employee").val(result.user.id);
    },
  });
}

$("#button-edit").click((e) => {
  e.preventDefault();
  let nama = $("#nama").val();
  let nip = $("#nip").val();
  let email = $("#email").val();
  let alamat = $("#alamat").val();
  let kontak = $("#kontak").val();
  $.ajax({
    url: "/api/entitas/" + $("#id-employee").val(),
    method: "PUT",
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify({
      nama: nama,
      nomorInduk: nip,
      alamat: alamat,
      email: email,
      noHp: kontak,
    }),
    success: (result) => {
      console.log(result);
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Guru has been updated",
        showConfirmButton: false,
        timer: 1000,
      });
      setTimeout(() => {
        location.reload();
      }, 1000);
    },
  });
});
function deleteById(id) {
  console.log(id);
  Swal.fire({
    title: "Are you sure?",
    text: "You won't be able to revert this!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "Yes, delete it!",
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire("Deleted!", "Your file has been deleted.", "success");
      $.ajax({
        url: "/api/entitas/" + id,
        method: "DELETE",
        contentType: "application/json",
        dataType: "json",
        success: (result) => {
          console.log(result);
          setTimeout(() => {
            location.reload();
          }, 1000);
        },
      });
    }
  });
}
