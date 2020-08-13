<template>
    <div>
        <div class="tabs">
            <ul>
                <li @click="activeForm=0" :class="{'is-active':activeForm==0}"><a>Additions</a></li>
<!--                <li><a>Overtime</a></li>-->
                <li @click="activeForm=1" :class="{'is-active':activeForm==1}"><a>Deductions</a></li>
            </ul>
        </div>
        <AdditionsList v-if="activeForm==0"></AdditionsList>
        <DeductionList v-if="activeForm==1"></DeductionList>
    </div>
</template>
<script>
    import AdditionsList from "./additions/AdditionsList";
    import DeductionList from "./deductions/DeductionList";

    export default {
        data() {
            return {
                activeForm: 0,
            }
        },
        components: {
            AdditionsList,
            DeductionList
        }

    }
</script>