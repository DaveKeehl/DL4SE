<template>
  <b-input-group class="date-select-input">
    <b-input type="text"
             :id="id"
             v-model.trim="input"
             autocomplete="off"
             :placeholder="placeholder"
             class="date-select-input-field"
    />
    <b-input-group-append class="date-select-input-group">
      <b-datepicker :id="`${id}-datepicker`" :aria-controls="id"
                    v-model="calendar" @context="onContext" :min="min" :max="max" start-weekday="1"
                    locale="en" :date-format-options="{ year: 'numeric', month: '2-digit', day: '2-digit' }"
                    selected-variant="secondary" button-variant="outline-secondary"
                    class="date-select-input-datepicker" menu-class="date-select-input-datepicker-menu"
                    hide-header button-only right :show-decade-nav="showDecadeNav"
      />
    </b-input-group-append>
  </b-input-group>
</template>

<script>
const yearInMs = 1000 * 60 * 60 * 24 * 365

export default {
  name: "b-date-select-input",
  props: {
    id: String,
    value: {
      type: String,
      default: null
    },
    placeholder: String,
    min: {
      type: [Date, String],
      default() {
        return new Date(0)
      }
    },
    max: {
      type: [Date, String],
      default() {
        return new Date(yearInMs * 100)
      }
    },
  },
  computed: {
    showDecadeNav() {
      const minMs = new Date(this.min).getTime()
      const maxMs = new Date(this.max).getTime()
      const difference = maxMs - minMs
      return difference >= yearInMs
    }
  },
  methods: {
    onContext(ctx) {
      this.input = ctx.selectedYMD
    }
  },
  watch: {
    input() {
      this.$emit('input', (this.input) ? this.input : null)
    }
  },
  data() {
    return {
      input: this.value,
      calendar: this.value
    }
  }
}
</script>