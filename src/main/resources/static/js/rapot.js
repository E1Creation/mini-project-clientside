$(document).ready(function () {
  $("#table-rapot").DataTable({
    ajax: {
      url: "/api/rapot",
      dataSrc: "",
    },
    columns: [
      {
        data: null,
        render: (data, type, row, meta) => {
          return meta.row + 1;
        },
      },
      {
        data: "mataPelajarans.nama",
      },
      {
        data: "nilai",
      },
      {
        data: "entitas.nama",
      },
      {
        data: "mataPelajarans.entitas[0].nama",
      },
      {
        data: "semester",
      },
      // {
      //   data: null,
      //   render: (data, type, row, meta) => {
      //     return `
      //       <tr th:each = "entitas : ${enti}">
      //       </tr>
      //       `;
      //   },
      // },
      {
        data: null,
        render: (data, type, row, meta) => {
          return ` 
                          <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateRapot" onclick="beforeUpdate(${data.id})">
                          Update
                          </button>
  
                           <button type="button" class="btn btn-danger" onclick="deleteRapot(${data.id})">
                          Delete
                          </button>
                      `;
        },
      },
    ],
  });
});
