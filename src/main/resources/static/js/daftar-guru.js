$(document).ready(function () {
  $.ajax({
    url: "/api/entitas/role/2",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: (result) => {
      // console.log(result);
      let data = ``;
      $.each(result, function (i, val) {
        console.log(val);
        data += `
        <tr>
        <td >${val.nama}</td>
        <td >${val.nomorInduk}</td>
        <td>${val.email}</td>
        <td>${val.alamat}</td>
        <td>${val.noHp}</td>
        <td sec:authorize="hasRole('ADMIN')">
          <button
            class="btn btn-primary btn-s"
            data-title="EditGuru"
            data-bs-toggle="modal"
            data-bs-target="#edit-guru"
            id="editGuru-list"
          >
            Edit
          </button>
          <button class="btn btn-danger" id="delete-guru" onclick="deleteById(${val.user.id})">
            Delete
          </button>
        </td>
      </tr>;`;
      });
      $("#daftar-guru").html(data);
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
        },
      });
      location.reload();
    }
  });
}
