<#import "tags.ftl" as tags>
<!DOCTYPE html>
<html>
<@tags.header.show></@tags.header.show>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name"><a href="/">智+</a></h1>
            </div>
            <h2><@tags.spring.message code="app.title" /></h2>
            <p><@tags.spring.message code="app.create.pleaseRegister"/></p>
            <form class="m-t" role="form" action="/account/save" method="post">
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control" name="username" placeholder="<@tags.spring.message code='app.form.placeholder.username'/>" required="">
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" class="form-control" name="password" placeholder="<@tags.spring.message code='app.form.placeholder.password'/>" required="">
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" class="form-control" name="confirm_password" placeholder="<@tags.spring.message code='app.form.placeholder.confirm-password'/>" required="">
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                    <input type="text" class="form-control" name="mobile" placeholder="<@tags.spring.message code='app.form.placeholder.mobile'/>" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b"><@tags.spring.message code="app.create.registerBtn"/></button>
                <p class="text-muted text-center"><small><@tags.spring.message code="app.create.haveAccount"/>?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="/login"><@tags.spring.message code="app.login.loginBtn"/></a>
            </form>
            <p class="m-t"> <small>Base on Bootstrap 3 &copy; 2015</small> </p>
        </div>
    </div>
    <@tags.static.js/>
</body>

</html>
