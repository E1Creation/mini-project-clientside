$("#register-button").click((e) => {
  e.preventDefault();
  let nama = $("#nama").val();
  let nomorInduk = parseInt($("#nomor-induk").val());
  let alamat = $("#alamat").val();
  let email = $("#email").val();
  let noHp = $("#nohp").val();
  let username = $("#username").val();
  let password = $("#password").val();
  let repeatPassword = $("#repeat-password").val();

  console.log(`nama : ${nama}
    nomor induk : ${nomorInduk}
    alamat : ${alamat}
    email = ${email}
    nohp : ${noHp}
    username : ${username}
    password : ${password}
    repeat password : ${repeatPassword}
  `);
  if (
    nama == null ||
    nomorInduk == null ||
    alamat == null ||
    email == null ||
    noHp == null ||
    username == null ||
    password == null ||
    repeatPassword == null
  ) {
    Swal.fire({
      position: "center",
      icon: "error",
      title: "Please fill all field",
      showConfirmButton: false,
    });
  } else if (password != repeatPassword) {
    Swal.fire({
      icon: "error",
      title: "Oops...",
      text: "password dan repeat password tidak sama",
      footer: '<a href="">Why do I have this issue?</a>',
      timer: 2000,
    });
  } else {
    $.ajax({
      method: "POST",
      url: "api/register",
      dataType: "JSON",
      contentType: "application/json",
      data: JSON.stringify({
        nama: nama,
        nomorInduk: nomorInduk,
        alamat: alamat,
        email: email,
        noHp: noHp,
        username: username,
        password: password,
      }),
      success: (result) => {
        console.log(result);
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Account has been created",
          showConfirmButton: false,
          timer: 1000,
        });
        setTimeout(() => {
          window.location.href = "/login";
        }, 2000);
      },
    });
  }
});
