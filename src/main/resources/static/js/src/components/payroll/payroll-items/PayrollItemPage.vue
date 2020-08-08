<template>
    <div>
        <div class="tabs">
            <ul>
                <li class="is-active"><a>Additions</a></li>
                <li><a>Overtime</a></li>
                <li><a>Deductions</a></li>
            </ul>
        </div>
        <AdditionsList></AdditionsList>
    </div>
</template>
<script>
    import AdditionsList from "./additions/AdditionsList";

    export default {
        components: {
            AdditionsList
        }

    }
</script>