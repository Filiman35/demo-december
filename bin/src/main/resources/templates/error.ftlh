<#import "basic.ftlh" as basicPage>

<@basicPage.mybasicmacro>
<div class="error-page-main">
    <div class="error-page-box-main">
        <p class="error-page-message">We've got a custom error page now.</p>
        <p class="error-page-message">${header}</p>
        <p class="error-page-advice">${messageMain} And we advise You: ${messageAdvice}</p>
    </div>
</div>
</@basicPage.mybasicmacro>