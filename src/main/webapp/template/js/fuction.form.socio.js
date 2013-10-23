jQuery(function($) {
    $('#pessoaFisica').click(function(event) {
        if ($("#pessoaFisica").is(':checked')) {
            $("#painelPessoaFisica").css("display", "block");
            $("#painelPessoaJuridica").css("display", "none");
            $("#painelPessoaJuridica input").val('');
            $("#painelPessoaJuridica select").val('');
            $("#pessoaJuridica").attr("checked", false);
        } else {
            $("#painelPessoaFisica").css("display", "none");
        }
    });

    $('#pessoaJuridica').click(function(event) {
        if ($("#pessoaJuridica").is(':checked')) {
            $("#painelPessoaJuridica").css("display", "block");
            $("#painelPessoaFisica input").val('');
            $("#painelPessoaFisica select").val('');
            $("#painelPessoaFisica").css("display", "none");
            $("#pessoaFisica").attr("checked", false);
        } else {
            $("#painelPessoaJuridica").css("display", "none");
        }
    });

    $(".mask-numero-telefone").mask("(99)9999-9999");
    $(".mask-cnpj").mask("99.999.999/9999-99");
    $(".mask-cpf").mask("999.999.999-99");
});

