function showDetail(id) {
  data = "";
  $.ajax({
    url: "/api/matapelajaran/" + id,
    method: "GET",
    dataType: "json",
    success: (result) => {
      console.log(result.nama);
      $("#nama-matapelajaran").text(result.nama);
      $.each(result.entitas, (i, val) => {
        console.log(val);
        data += `
            <tr>
                  <td>${val.nomorInduk}</td>
                  <td>${val.nama}</td>
                  </td>
                </tr>
            `;
      });
      $("#body-guru").html(data);
    },
  });
}

function showSelectInput() {
  let select = "";
  $.ajax({
    url: "/api/entitas/role/2",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: (result) => {
      console.log(result);
      $.each(result, (i, val) => {
        console.log("id : " + val.id);
        select += `
                <option value=${val.id}>${val.nama}</option>
                `;
      });
      $("#select-guru").html(select);
    },
  });
}

$("#button-create").click((e) => {
  e.preventDefault();
  let namaPelajaran = $("#nama-pelajaran").val();
  let guruList = [];
  let guru = $("#select-guru").val();
  console.log(guru);
  guruList.push(guru);
  console.log(guruList);

  if (namaPelajaran == "") {
    Swal.fire({
      position: "center",
      icon: "error",
      title: "Please fill all field",
      showConfirmButton: false,
    });
  }
  $.ajax({
    url: "/api/matapelajaran/entitas",
    method: "POST",
    contentType: "application/json",
    dataType: "json",
    data: JSON.stringify({
      namaPelajaran: namaPelajaran,
      entitas: guruList,
    }),
    success: (result) => {
      $("#nama-pelajaran").val("");
      console.log(result);
      Swal.fire({
        position: "center",
        icon: "success",
        title: "Matpel has been created",
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
        url: "/api/matapelajaran/" + id,
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
