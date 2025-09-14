// Animar secciones al hacer scroll
const fadeElements = document.querySelectorAll('.fade-in');

const observer = new IntersectionObserver((entries) => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add('visible');
    }
  });
}, { threshold: 0.2 });

fadeElements.forEach(el => observer.observe(el));
// Mostrar/ocultar resumen con animación
const toggleButtons = document.querySelectorAll('.toggle-btn');
toggleButtons.forEach(btn => {
  btn.addEventListener('click', () => {
    const summary = btn.nextElementSibling;
    summary.classList.toggle('show');
    btn.textContent = summary.classList.contains('show')
      ? 'Ocultar resumen'
      : 'Ver resumen';
  });
});
