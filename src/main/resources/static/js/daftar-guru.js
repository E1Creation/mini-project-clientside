$(document).ready(function () {
  $.ajax({
    url: "/api/entitas/role/2",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: (result) => {
      console.log(result);
      let data = ``;
      $.each(result, function (i, val) {
        data += `
        <tr>
        <td th:text="${val.nama}">Mohsin</td>
        <td th:text="${val.nomorInduk}">1234</td>
        <td th:text="${val.email}">mohsin@gmail.com</td>
        <td th:text="${val.alamat}">Jl Testing</td>
        <td th:text="${val.noHp}">086785747383</td>
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
          <button class="btn btn-danger" id="delete-guru">
            Delete
          </button>
        </td>
      </tr>;`;
      });
      $("#daftar-guru").html(data);
    },
  });
});

$("#delete-guru").click((e) => {
  console.log("[[${daftarGuru.id}]]");
});

function deleteById(id) {
  e.preventDefault();

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
    }
  });
}
