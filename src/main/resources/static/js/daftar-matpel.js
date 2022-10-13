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
