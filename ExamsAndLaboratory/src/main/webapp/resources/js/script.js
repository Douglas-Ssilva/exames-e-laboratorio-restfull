
    function verify(xhr, status, args, dlg, tbl) {
        if(args.validationFailed) { /*True quando o required dá problema, não preencher campos*/
            PF(dlg).jq.effect("shake", {times:5}, 100);
        }
        else {/*Caso preencha os campos...Substitui o oncomplete*/
            PF(dlg).hide();
            PF(tbl).clearFilters();
        }
    }
    
    function verifyLogin(xhr, status, args, dlg) {
    	if(args.validationFailed) { 
    		PF(dlg).jq.effect("shake", {times:5}, 100);
    	}
    	else {
    		console.log('Login');
//    		PF(dlg).hide(); assim quando errar a senha o dialog nao some
    	}
    }
