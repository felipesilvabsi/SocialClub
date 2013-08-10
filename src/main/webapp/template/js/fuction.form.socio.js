$(document).ready(function() {
    $('#pessoaFisica').click(function(event) {
        if ($("#pessoaFisica").is(':checked')) {
            $("#painelPessoaFisica").css("display", "block");
            $("#painelPessoaJuridica").css("display", "none");
            $("#pessoaJuridica").attr("checked", false);
        } else {
            $("#painelPessoaFisica").css("display", "none");
        }
    });

    $('#pessoaJuridica').click(function(event) {
        if ($("#pessoaJuridica").is(':checked')) {
            $("#painelPessoaJuridica").css("display", "block");
            $("#painelPessoaFisica").css("display", "none");
            $("#pessoaFisica").attr("checked", false);
        } else {
            $("#painelPessoaJuridica").css("display", "none");
        }
    });
});

$(document).ready(function() {
    $(".mask-cpf").mask("999.999.999-99");
});